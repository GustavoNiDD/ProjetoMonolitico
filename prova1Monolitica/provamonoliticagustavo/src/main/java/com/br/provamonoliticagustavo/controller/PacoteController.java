package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Pacote;
import com.br.provamonoliticagustavo.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public List<Pacote> getAllPacotes() {
        return pacoteService.getAllPacotes();
    }

    @PostMapping
    public Pacote addPacote(@RequestBody Pacote pacote) {
        return pacoteService.addPacote(pacote);
    }

    @GetMapping("/{id}")
    public Pacote getPacoteById(@PathVariable String id) {
        return pacoteService.getPacoteById(id);
    }

    @PutMapping("/{id}")
    public Pacote updatePacote(@PathVariable String id, @RequestBody Pacote updatedPacote) {
        return pacoteService.updatePacote(id, updatedPacote);
    }

    @DeleteMapping("/{id}")
    public void deletePacote(@PathVariable String id) {
        pacoteService.deletePacote(id);
    }
}
