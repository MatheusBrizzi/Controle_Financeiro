package com.controle.financeiro.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.financeiro.dto.ContatoResponseDTO;
import com.controle.financeiro.dto.UsuarioRequestDTO;
import com.controle.financeiro.dto.UsuarioResponseDTO;
import com.controle.financeiro.exception.RecursoNaoEncontradoException;
import com.controle.financeiro.exception.RegraNegocioException;
import com.controle.financeiro.model.Contato;
import com.controle.financeiro.model.Usuario;
import com.controle.financeiro.repository.ContatoRepository;
import com.controle.financeiro.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ContatoRepository contatoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, ContatoRepository contatoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.contatoRepository = contatoRepository;
    }

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        if (contatoRepository.existsByEmail(dto.emailPrincipal())) {
            throw new RegraNegocioException("Este e-mail já está em uso por outro contato.");
        }

        Usuario usuario = new Usuario(dto.nome(), dto.senha());
        Contato contatoPrincipal = new Contato(dto.emailPrincipal(), true, usuario);
        usuario.adicionarContato(contatoPrincipal);

        Usuario salvo = usuarioRepository.save(usuario);
        return mapToDTO(salvo);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado."));
        return mapToDTO(usuario);
    }

    private UsuarioResponseDTO mapToDTO(Usuario usuario) {
        List<ContatoResponseDTO> contatosDto = usuario.getContatos().stream()
                .map(c -> new ContatoResponseDTO(c.getId(), c.getEmail(), c.getPrincipal()))
                .collect(Collectors.toList());

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getDataCriacao(), contatosDto);
    }
}