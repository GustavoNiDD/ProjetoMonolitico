package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Rastreamento;
import com.br.provamonoliticagustavo.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @PostMapping
    public Rastreamento addRastreamento(@RequestBody Rastreamento rastreamento) {
        return rastreamentoService.addRastreamento(rastreamento);
    }

    @GetMapping("/{id}")
    public List<Rastreamento> getRastreamentosByPacoteId(@PathVariable String id) {
        return rastreamentoService.getRastreamentosByPacoteId(id);
    }
}
