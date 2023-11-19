package model;

import lombok.Data;

@Data
public class TelaModel {
    private String tipo, proporcao, atualizacao;

    public TelaModel(String tipo, String proporcao, String atualizacao) {
        this.tipo = tipo;
        this.proporcao = proporcao;
        this.atualizacao = atualizacao;
    }
}
