package com.controle.financeiro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.financeiro.dto.ContatoRequestDTO;
import com.controle.financeiro.dto.ContatoResponseDTO;
import com.controle.financeiro.service.ContatoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> adicionarEmail(
            @RequestHeader("X-Usuario-Id") Long usuarioId,
            @RequestBody @Valid ContatoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarEmail(usuarioId, dto));
    }

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> listar(@RequestHeader("X-Usuario-Id") Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }
}