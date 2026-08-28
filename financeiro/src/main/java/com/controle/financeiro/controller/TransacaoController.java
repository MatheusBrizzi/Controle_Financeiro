package com.controle.financeiro.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.financeiro.dto.TransacaoRequestDTO;
import com.controle.financeiro.dto.TransacaoResponseDTO;
import com.controle.financeiro.service.TransacaoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> registrar(
            @RequestHeader("X-Usuario-Id") Long usuarioId, 
            @RequestBody @Valid TransacaoRequestDTO dto) {
        
        TransacaoResponseDTO response = service.registrarTransacao(usuarioId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listar(@RequestHeader("X-Usuario-Id") Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }

    @GetMapping("/saldo")
    public ResponseEntity<BigDecimal> obterSaldo(@RequestHeader("X-Usuario-Id") Long usuarioId) {
        return ResponseEntity.ok(service.calcularSaldo(usuarioId));
    }
}