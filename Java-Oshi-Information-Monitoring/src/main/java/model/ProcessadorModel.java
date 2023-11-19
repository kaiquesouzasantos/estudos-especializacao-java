package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessadorModel {
    private String nome, fabricante, microarquitetura, arquitetura, temperatura, tensao, frequenciaMaxima, ventoinhas, utilizacaoPorcentagem, mediaUtilizacaoPorcentagem;
    private int nucleoFisico, nucleoLogico;
}
