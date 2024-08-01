package com.br.provamonoliticagustavo.controller;

import com.br.provamonoliticagustavo.model.Endereco;
import com.br.provamonoliticagustavo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @PostMapping
    public Endereco addEndereco(@RequestBody Endereco endereco) {
        return enderecoService.addEndereco(endereco);
    }
}
