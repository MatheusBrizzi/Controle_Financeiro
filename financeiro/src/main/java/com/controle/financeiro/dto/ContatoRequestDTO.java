package com.controle.financeiro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoRequestDTO(
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email,

    @NotNull(message = "O campo principal deve ser informado")
    Boolean principal
) {}