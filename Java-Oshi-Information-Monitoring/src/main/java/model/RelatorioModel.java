package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioModel {
    private SistemaModel sistema;
    private ArmazenamentoModel armazenamento;
    private MemoriaRamModel memoriaRam;
    private ProcessadorModel processador;
    private PlacaGraficaModel placaGrafica;
    private TelaModel tela;
    private BateriaModel bateria;
    private RedeModel rede;
    private InternetModel internet;
    private DispositivosUsbModel dispositivosUsb;
}
