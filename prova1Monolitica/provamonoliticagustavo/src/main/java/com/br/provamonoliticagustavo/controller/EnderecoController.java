package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Endereco;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    // Simulação de armazenamento em memória
    private final List<Endereco> enderecos = new ArrayList<>();

    // Consulta todos os endereços
    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecos;
    }

    // Adiciona um novo endereço
    @PostMapping
    public Endereco addEndereco(@RequestBody Endereco endereco) {
        enderecos.add(endereco);
        return endereco;
    }
}
