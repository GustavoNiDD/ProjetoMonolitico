package com.br.provamonoliticagustavo.service;

import com.br.provamonoliticagustavo.model.Rastreamento;
import com.br.provamonoliticagustavo.repository.RastreamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Rastreamento> getAllRastreamentos() {
        return rastreamentoRepository.findAll();
    }

    public Rastreamento getRastreamentoById(Long id) {
        return rastreamentoRepository.findById(id).orElse(null);
    }

    public Rastreamento addRastreamento(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    public Rastreamento updateRastreamento(Long id, Rastreamento rastreamento) {
        if (rastreamentoRepository.existsById(id)) {
            rastreamento.setId(id);
            return rastreamentoRepository.save(rastreamento);
        }
        return null;
    }

    public void deleteRastreamento(Long id) {
        if (rastreamentoRepository.existsById(id)) {
            rastreamentoRepository.deleteById(id);
        }
    }

    public List<Rastreamento> getRastreamentosByPacoteId(Long pacoteId) {
        return rastreamentoRepository.findByPacoteId(pacoteId);
    }
}
