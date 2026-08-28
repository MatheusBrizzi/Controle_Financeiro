package com.controle.financeiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.financeiro.dto.ContatoRequestDTO;
import com.controle.financeiro.dto.ContatoResponseDTO;
import com.controle.financeiro.exception.RecursoNaoEncontradoException;
import com.controle.financeiro.exception.RegraNegocioException;
import com.controle.financeiro.model.Contato;
import com.controle.financeiro.model.Usuario;
import com.controle.financeiro.repository.ContatoRepository;
import com.controle.financeiro.repository.UsuarioRepository;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final UsuarioRepository usuarioRepository;

    public ContatoService(ContatoRepository contatoRepository, UsuarioRepository usuarioRepository) {
        this.contatoRepository = contatoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ContatoResponseDTO adicionarEmail(Long usuarioId, ContatoRequestDTO dto) {
        if (contatoRepository.existsByEmail(dto.email())) {
            throw new RegraNegocioException("Este e-mail já está cadastrado no sistema.");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado."));

        Contato contato = new Contato(dto.email(), dto.principal(), usuario);
        Contato salvo = contatoRepository.save(contato);

        return new ContatoResponseDTO(salvo.getId(), salvo.getEmail(), salvo.getPrincipal());
    }

    @Transactional(readOnly = true)
    public List<ContatoResponseDTO> listarPorUsuario(Long usuarioId) {
        return contatoRepository.findByUsuarioId(usuarioId).stream()
                .map(c -> new ContatoResponseDTO(c.getId(), c.getEmail(), c.getPrincipal()))
                .collect(Collectors.toList());
    }
}