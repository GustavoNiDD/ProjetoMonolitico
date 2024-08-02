package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Pacote;
import com.br.provamonoliticagustavo.model.Rastreamento;
import com.br.provamonoliticagustavo.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public ResponseEntity<List<Pacote>> getAllPacotes() {
        List<Pacote> pacotes = pacoteService.getAllPacotes();
        return new ResponseEntity<>(pacotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
        Pacote pacote = pacoteService.getPacoteById(id);
        return pacote != null ? new ResponseEntity<>(pacote, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pacote> criarPacote(@RequestBody Pacote pacote) {
        Pacote novoPacote = pacoteService.criarPacote(pacote);
        return new ResponseEntity<>(novoPacote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacote> atualizarPacote(@PathVariable Long id, @RequestBody Pacote pacote) {
        Pacote pacoteAtualizado = pacoteService.atualizarPacote(id, pacote);
        return pacoteAtualizado != null ? new ResponseEntity<>(pacoteAtualizado, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPacote(@PathVariable Long id) {
        boolean deleted = pacoteService.deletarPacote(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{pacoteId}/rastreamentos")
    public ResponseEntity<Rastreamento> adicionarRastreamento(@PathVariable Long pacoteId,
            @RequestBody Rastreamento rastreamento) {
        Rastreamento novoRastreamento = pacoteService.adicionarRastreamento(pacoteId, rastreamento);
        return new ResponseEntity<>(novoRastreamento, HttpStatus.CREATED);
    }
}
