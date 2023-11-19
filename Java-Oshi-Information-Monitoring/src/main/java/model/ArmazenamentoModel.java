package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArmazenamentoModel {
    private String tempoTransferencia;
    private List<UnidadeArmazenamentoModel> particoes;
}
