package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import oshi.util.FormatUtil;

@Data
@AllArgsConstructor
public class UnidadeArmazenamentoModel {
    private String nome, identificacao, rotulo, armazenamentoDisponivel, armazenamentoMaximo;
}
