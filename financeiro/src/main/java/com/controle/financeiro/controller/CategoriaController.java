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

import com.controle.financeiro.dto.CategoriaRequestDTO;
import com.controle.financeiro.dto.CategoriaResponseDTO;
import com.controle.financeiro.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> criar(
            @RequestHeader("X-Usuario-Id") Long usuarioId,
            @RequestBody @Valid CategoriaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(usuarioId, dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listar(@RequestHeader("X-Usuario-Id") Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }
}