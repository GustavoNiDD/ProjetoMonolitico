package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Rastreamento;
import com.br.provamonoliticagustavo.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping("/pacote/{pacoteId}")
    public List<Rastreamento> getRastreamentosByPacoteId(@PathVariable Long pacoteId) {
        return rastreamentoService.getRastreamentosByPacoteId(pacoteId);
    }
}
