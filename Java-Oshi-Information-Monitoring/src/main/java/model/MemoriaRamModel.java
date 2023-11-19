package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MemoriaRamModel {
    private String memoriaRamTotal, memoriaRamUso, memoriaRamPorcentagemUso;
    private List<UnidadeMemoriaRamModel> unidadesMemoriaRam;
}
