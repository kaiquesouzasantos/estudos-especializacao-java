package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnidadeMemoriaRamModel {
    private String capacidade, velocidade, local, fabricante, tipo;
}
