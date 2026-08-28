package com.controle.financeiro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.financeiro.model.Contato;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Optional<Contato> findByEmail(String email);

    
    boolean existsByEmail(String email);

 
    List<Contato> findByUsuarioId(Long usuarioId);
}