    package com.br.provamonoliticagustavo.service;

    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.provamonoliticagustavo.model.Endereco;
import com.br.provamonoliticagustavo.model.Pacote;
import com.br.provamonoliticagustavo.model.Rastreamento;
import com.br.provamonoliticagustavo.repository.EnderecoRepository;
import com.br.provamonoliticagustavo.repository.PacoteRepository;
import com.br.provamonoliticagustavo.repository.RastreamentoRepository;

import jakarta.persistence.EntityNotFoundException;

    @Service
    public class PacoteService {
    
        @Autowired
        private PacoteRepository pacoteRepository;
    
        @Autowired
        private RastreamentoRepository rastreamentoRepository;
    
        @Autowired
        private EnderecoRepository enderecoRepository;
    
        public List<Pacote> getAllPacotes() {
            return pacoteRepository.findAll();
        }
    
        public Pacote getPacoteById(Long id) {
            return pacoteRepository.findById(id).orElse(null);
        }
    
        public Pacote criarPacote(Pacote pacote) {
            Endereco endereco = pacote.getEndereco();
            if (endereco != null && endereco.getId() == null) {
                endereco = enderecoRepository.save(endereco); // Salva o endereço primeiro
                pacote.setEndereco(endereco); // Atualiza o pacote com o endereço salvo
            }
            return pacoteRepository.save(pacote); // Então salva o pacote
        }
    
        public Pacote atualizarPacote(Long id, Pacote pacote) {
            if (pacoteRepository.existsById(id)) {
                pacote.setId(id);
                return pacoteRepository.save(pacote);
            }
            return null;
        }
    
        public boolean deletarPacote(Long id) {
            if (pacoteRepository.existsById(id)) {
                pacoteRepository.deleteById(id);
                return true;
            }
            return false;
        }
    
        public Rastreamento adicionarRastreamento(Long pacoteId, Rastreamento rastreamento) {
            Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new EntityNotFoundException("Pacote não encontrado"));
    
            rastreamento.setPacote(pacote);
            rastreamentoRepository.save(rastreamento);
    
            pacote.getRastreamentos().add(rastreamento);
            pacoteRepository.save(pacote);
    
            return rastreamento;
        }
        
    }
