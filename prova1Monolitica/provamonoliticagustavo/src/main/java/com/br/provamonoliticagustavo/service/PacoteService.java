package com.br.provamonoliticagustavo.service;

import com.br.provamonoliticagustavo.model.Pacote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    // Simulação de armazenamento em memória
    private final List<Pacote> pacotes = new ArrayList<>();

    public List<Pacote> getAllPacotes() {
        return pacotes;
    }

    public Pacote addPacote(Pacote pacote) {
        pacotes.add(pacote);
        return pacote;
    }

    public Pacote getPacoteById(String id) {
        return pacotes.stream()
                      .filter(pacote -> pacote.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }

    public Pacote updatePacote(String id, Pacote updatedPacote) {
        Pacote pacote = getPacoteById(id);
        if (pacote != null) {
            pacote.setDestinatario(updatedPacote.getDestinatario());
            pacote.setEndereco(updatedPacote.getEndereco());
            pacote.setStatus(updatedPacote.getStatus());
        }
        return pacote;
    }

    public void deletePacote(String id) {
        pacotes.removeIf(pacote -> pacote.getId().equals(id));
    }
}
