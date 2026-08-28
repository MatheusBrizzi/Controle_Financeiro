package com.controle.financeiro.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.financeiro.dto.CategoriaResponseDTO;
import com.controle.financeiro.dto.TransacaoRequestDTO;
import com.controle.financeiro.dto.TransacaoResponseDTO;
import com.controle.financeiro.exception.RecursoNaoEncontradoException;
import com.controle.financeiro.exception.RegraNegocioException;
import com.controle.financeiro.model.Categoria;
import com.controle.financeiro.model.Transacao;
import com.controle.financeiro.model.Usuario;
import com.controle.financeiro.repository.CategoriaRepository;
import com.controle.financeiro.repository.TransacaoRepository;
import com.controle.financeiro.repository.UsuarioRepository;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public TransacaoResponseDTO registrarTransacao(Long usuarioId, TransacaoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado."));

        Categoria categoria = categoriaRepository.findByIdAndUsuarioId(dto.categoriaId(), usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada ou não pertence ao usuário."));

        if (categoria.getTipo() != dto.tipo()) {
            throw new RegraNegocioException("O tipo da transação deve ser igual ao tipo da categoria (RECEITA ou DESPESA).");
        }

        Transacao transacao = new Transacao(dto.descricao(), dto.valor(), dto.data(), dto.tipo(), usuario, categoria);
        Transacao salva = transacaoRepository.save(transacao);

        return mapToDTO(salva);
    }

    @Transactional(readOnly = true)
    public List<TransacaoResponseDTO> listarPorUsuario(Long usuarioId) {
        return transacaoRepository.findByUsuarioId(usuarioId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BigDecimal calcularSaldo(Long usuarioId) {
        List<Transacao> transacoes = transacaoRepository.findByUsuarioId(usuarioId);

        BigDecimal receitas = transacoes.stream()
                .filter(t -> t.getTipo() == Categoria.TipoTransacao.RECEITA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal despesas = transacoes.stream()
                .filter(t -> t.getTipo() == Categoria.TipoTransacao.DESPESA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return receitas.subtract(despesas);
    }

    private TransacaoResponseDTO mapToDTO(Transacao t) {
        CategoriaResponseDTO catDto = new CategoriaResponseDTO(
                t.getCategoria().getId(),
                t.getCategoria().getNome(),
                t.getCategoria().getTipo()
        );
        return new TransacaoResponseDTO(t.getId(), t.getDescricao(), t.getValor(), t.getData(), t.getTipo(), catDto);
    }
}