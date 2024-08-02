package com.br.provamonoliticagustavo.repository;

import com.br.provamonoliticagustavo.model.Rastreamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
    List<Rastreamento> findByPacoteId(Long pacoteId);
}
