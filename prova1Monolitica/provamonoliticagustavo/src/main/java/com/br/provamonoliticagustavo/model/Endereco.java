package com.br.provamonoliticagustavo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public String getEnderecoCompleto() {
        return String.format("%s, %s - %s, %s, %s", rua, numero, cidade, estado, cep);
    }
}
