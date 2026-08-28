package com.controle.financeiro.repository;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controle.financeiro.model.*;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByUsuarioId(Long usuarioId);

    Optional<Transacao> findByIdAndUsuarioId(Long id, Long usuarioId);

    List<Transacao> findByUsuarioIdAndDataBetween(Long usuarioId, LocalDate inicio, LocalDate fim);

    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transacao t WHERE t.usuario.id = :usuarioId AND t.tipo = :tipo")
    BigDecimal somarTotalPorTipoEUsuario(@Param("usuarioId") Long usuarioId, @Param("tipo") Categoria.TipoTransacao tipo);
}
