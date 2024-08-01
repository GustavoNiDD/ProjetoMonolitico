package com.br.provamonoliticagustavo.model;

public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String numero, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getEnderecoCompleto() {
        return String.format("%s, %s - %s, %s, %s", rua, numero, cidade, estado, cep);
    }

    // Getters e Setters
}
