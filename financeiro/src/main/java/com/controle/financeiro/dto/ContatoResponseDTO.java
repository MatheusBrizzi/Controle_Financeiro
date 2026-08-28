package com.controle.financeiro.dto;

public record ContatoResponseDTO(
    Long id,
    String email,
    Boolean principal
) {}