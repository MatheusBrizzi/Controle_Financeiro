package com.controle.financeiro.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.financeiro.dto.LoginRequestDTO;
import com.controle.financeiro.dto.LoginResponseDTO;
import com.controle.financeiro.exception.RegraNegocioException;
import com.controle.financeiro.model.Contato;
import com.controle.financeiro.model.Usuario;
import com.controle.financeiro.repository.ContatoRepository;

@Service
public class AuthService {

    private final ContatoRepository contatoRepository;

    public AuthService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        Contato contato = contatoRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RegraNegocioException("E-mail ou senha inválidos."));

        Usuario usuario = contato.getUsuario();

        if (!usuario.getSenha().equals(dto.senha())) {
            throw new RegraNegocioException("E-mail ou senha inválidos.");
        }

        
        String tokenFicticio = "mock-jwt-token-usuario-" + usuario.getId();
        return new LoginResponseDTO(tokenFicticio, usuario.getId(), usuario.getNome());
    }
}