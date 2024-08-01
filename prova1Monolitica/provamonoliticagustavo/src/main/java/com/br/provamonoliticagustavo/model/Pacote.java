package com.br.provamonoliticagustavo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pacote {
    private String id;
    private String destinatario;
    private Endereco endereco;
    private String status; // "pendente", "em trânsito", "entregue"
    private List<Rastreamento> rastreamentoHistorico = new ArrayList<>();

    public Pacote(String id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        rastreamentoHistorico.add(new Rastreamento(dataHora, novoStatus, localizacao));
    }

    public String consultarInformacoes() {
        StringBuilder info = new StringBuilder();
        info.append("ID: ").append(id).append("\n");
        info.append("Destinatário: ").append(destinatario).append("\n");
        info.append("Endereço: ").append(endereco.getEnderecoCompleto()).append("\n");
        info.append("Status: ").append(status).append("\n");
        info.append("Rastreamento Histórico:\n");
        for (Rastreamento rastreamento : rastreamentoHistorico) {
            info.append(rastreamento.getResumo()).append("\n");
        }
        return info.toString();
    }

    // Getters e Setters
}
