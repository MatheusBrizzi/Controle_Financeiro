package com.controle.financeiro.dto;

public record LoginResponseDTO(
    String token,
    String tipoToken,
    Long usuarioId,
    String nome
) {
    public LoginResponseDTO(String token, Long usuarioId, String nome) {
        this(token, "Bearer", usuarioId, nome);
    }
}