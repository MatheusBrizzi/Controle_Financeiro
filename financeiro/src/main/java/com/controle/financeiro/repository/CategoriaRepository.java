package com.controle.financeiro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.financeiro.model.Categoria;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    
    List<Categoria> findByUsuarioId(Long usuarioId);

    Optional<Categoria> findByIdAndUsuarioId(Long id, Long usuarioId);

    List<Categoria> findByUsuarioIdAndTipo(Long usuarioId, Categoria.TipoTransacao tipo);
}