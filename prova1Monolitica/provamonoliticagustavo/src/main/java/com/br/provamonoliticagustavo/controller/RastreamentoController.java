package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Pacote;
import com.br.provamonoliticagustavo.model.Rastreamento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    // Simulação de armazenamento em memória
    private final List<Rastreamento> rastreamentos = new ArrayList<>();
    private final List<Pacote> pacotes = new ArrayList<>();

    // Adiciona um novo rastreamento
    @PostMapping
    public Rastreamento addRastreamento(@RequestBody Rastreamento rastreamento) {
        rastreamentos.add(rastreamento);
        return rastreamento;
    }

    // Consulta todos os rastreamentos de um pacote específico
    @GetMapping("/{id}")
    public List<Rastreamento> getRastreamentosByPacoteId(@PathVariable String id) {
        Pacote pacote = pacotes.stream()
                               .filter(p -> p.getId().equals(id))
                               .findFirst()
                               .orElse(null);
        if (pacote != null) {
            return pacote.getRastreamentoHistorico();
        }
        return new ArrayList<>();
    }
}
