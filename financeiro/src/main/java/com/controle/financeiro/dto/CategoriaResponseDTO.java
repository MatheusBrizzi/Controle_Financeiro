package com.controle.financeiro.dto;

import com.controle.financeiro.model.*;

public record CategoriaResponseDTO(
    Long id,
    String nome,
    Categoria.TipoTransacao tipo
) {}