package com.controle.financeiro.service;





import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.financeiro.dto.CategoriaRequestDTO;
import com.controle.financeiro.dto.CategoriaResponseDTO;
import com.controle.financeiro.exception.RecursoNaoEncontradoException;
import com.controle.financeiro.model.Categoria;
import com.controle.financeiro.model.Usuario;
import com.controle.financeiro.repository.CategoriaRepository;
import com.controle.financeiro.repository.UsuarioRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository) {
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public CategoriaResponseDTO criar(Long usuarioId, CategoriaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado."));

        Categoria categoria = new Categoria(dto.nome(), dto.tipo(), usuario);
        Categoria salva = categoriaRepository.save(categoria);

        return new CategoriaResponseDTO(salva.getId(), salva.getNome(), salva.getTipo());
    }

    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> listarPorUsuario(Long usuarioId) {
        return categoriaRepository.findByUsuarioId(usuarioId).stream()
                .map(c -> new CategoriaResponseDTO(c.getId(), c.getNome(), c.getTipo()))
                .collect(Collectors.toList());
    }
}