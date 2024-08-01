package com.br.provamonoliticagustavo.service;

import com.br.provamonoliticagustavo.model.Pacote;
import com.br.provamonoliticagustavo.model.Rastreamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RastreamentoService {

    // Simulação de armazenamento em memória
    private final List<Rastreamento> rastreamentos = new ArrayList<>();
    private final List<Pacote> pacotes = new ArrayList<>();

    public Rastreamento addRastreamento(Rastreamento rastreamento) {
        rastreamentos.add(rastreamento);
        return rastreamento;
    }

    public List<Rastreamento> getRastreamentosByPacoteId(String id) {
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
