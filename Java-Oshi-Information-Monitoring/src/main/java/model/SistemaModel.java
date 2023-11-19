package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SistemaModel {
    private String fabricante, familia, versao, tempoInicializacao, tempoAtividade;
    private long bit, instancias, processos, descritoresAbertos, limiteDescritoresAbertos;
}
