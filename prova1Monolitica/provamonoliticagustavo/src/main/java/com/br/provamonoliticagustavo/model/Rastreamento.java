package com.br.provamonoliticagustavo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rastreamento {
    private Date dataHora;
    private String status;
    private String localizacao;

    public String getResumo() {
        return String.format("Data/Hora: %s, Status: %s, Localização: %s",
                dataHora.toString(), status, localizacao != null ? localizacao : "não disponível");
    }

    // Getters e Setters
}
