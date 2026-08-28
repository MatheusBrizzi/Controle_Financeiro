package com.controle.financeiro.dto;

import com.controle.financeiro.model.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoRequestDTO(
    @NotBlank(message = "A descrição é obrigatória")
    String descricao,

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    BigDecimal valor,

    @NotNull(message = "A data é obrigatória")
    LocalDate data,

    @NotNull(message = "O tipo (RECEITA ou DESPESA) é obrigatório")
    Categoria.TipoTransacao tipo,

    @NotNull(message = "O ID da categoria é obrigatório")
    Long categoriaId
) {}