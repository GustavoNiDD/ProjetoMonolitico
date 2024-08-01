package com.br.provamonoliticagustavo.service;

import com.br.provamonoliticagustavo.model.Endereco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    // Simulação de armazenamento em memória
    private final List<Endereco> enderecos = new ArrayList<>();

    public List<Endereco> getAllEnderecos() {
        return enderecos;
    }

    public Endereco addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        return endereco;
    }
}
