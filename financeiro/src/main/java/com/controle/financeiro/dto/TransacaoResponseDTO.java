package com.controle.financeiro.dto;

import com.controle.financeiro.dto.*;
import com.controle.financeiro.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoResponseDTO(
    Long id,
    String descricao,
    BigDecimal valor,
    LocalDate data,
    Categoria.TipoTransacao tipo,
    CategoriaResponseDTO categoria
) {}