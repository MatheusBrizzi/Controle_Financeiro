package com.controle.financeiro.dto;

import com.controle.financeiro.dto.*;
import java.time.LocalDateTime;
import java.util.List;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    LocalDateTime dataCriacao,
    List<ContatoResponseDTO> contatos
) {}