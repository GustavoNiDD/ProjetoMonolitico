package com.br.provamonoliticagustavo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private String destinatario;

    @ManyToOne
    private Endereco endereco;

    private String status;

    @OneToMany(mappedBy = "pacote")
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setDataHora(dataHora);
        rastreamento.setStatus(novoStatus);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setPacote(this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(identificador).append("\n");
        sb.append("Destinatário: ").append(destinatario).append("\n");
        sb.append("Endereço: ").append(endereco.getEnderecoCompleto()).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Rastreamento:\n");
        for (Rastreamento r : rastreamentos) {
            sb.append(r.getResumo()).append("\n");
        }
        return sb.toString();
    }
}
