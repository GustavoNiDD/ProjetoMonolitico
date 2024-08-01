package com.br.provamonoliticagustavo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.provamonoliticagustavo.model.Pacote;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    // Simulação de armazenamento em memória
    private final List<Pacote> pacotes = new ArrayList<>();

    // Consulta todos os pacotes
    @GetMapping
    public List<Pacote> getAllPacotes() {
        return pacotes;
    }

    // Adiciona um novo pacote
    @PostMapping
    public Pacote addPacote(@RequestBody Pacote pacote) {
        pacotes.add(pacote);
        return pacote;
    }

    // Consulta um pacote específico
    @GetMapping("/{id}")
    public Pacote getPacoteById(@PathVariable String id) {
        return pacotes.stream()
                      .filter(pacote -> pacote.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }

    // Atualiza as informações de um pacote
    @PutMapping("/{id}")
    public Pacote updatePacote(@PathVariable String id, @RequestBody Pacote updatedPacote) {
        Pacote pacote = pacotes.stream()
                               .filter(p -> p.getId().equals(id))
                               .findFirst()
                               .orElse(null);
        if (pacote != null) {
            pacote.setDestinatario(updatedPacote.getDestinatario());
            pacote.setEndereco(updatedPacote.getEndereco());
            pacote.setStatus(updatedPacote.getStatus());
        }
        return pacote;
    }

    // Remove um pacote
    @DeleteMapping("/{id}")
    public void deletePacote(@PathVariable String id) {
        pacotes.removeIf(pacote -> pacote.getId().equals(id));
    }
}
