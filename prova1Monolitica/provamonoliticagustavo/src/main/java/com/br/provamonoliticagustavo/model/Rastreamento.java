package com.br.provamonoliticagustavo.model;

import java.util.Date;

public class Rastreamento {
    private Date dataHora;
    private String status;
    private String localizacao;

    public Rastreamento(Date dataHora, String status, String localizacao) {
        this.dataHora = dataHora;
        this.status = status;
        this.localizacao = localizacao;
    }

    public String getResumo() {
        return String.format("Data/Hora: %s, Status: %s, Localização: %s",
                             dataHora.toString(), status, localizacao != null ? localizacao : "não disponível");
    }

    // Getters e Setters
}
