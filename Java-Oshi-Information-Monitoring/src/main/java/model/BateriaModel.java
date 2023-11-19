package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BateriaModel {
    private String taxaUso, tensao, amperagem, nivelAtual, capacidadeAlimentacao, porcentagemAtual, temperatura;
    private boolean alimentando, carregando, descarregando;
}
