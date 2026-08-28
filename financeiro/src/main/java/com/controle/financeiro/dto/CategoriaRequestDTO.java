package com.controle.financeiro.dto;

import com.controle.financeiro.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoriaRequestDTO(
    @NotBlank(message = "O nome da categoria é obrigatório")
    String nome,

    @NotNull(message = "O tipo da transação (RECEITA ou DESPESA) é obrigatório")
    Categoria.TipoTransacao tipo
) {}