package mapper;

import model.RelatorioModel;
import service.*;

public class RelatorioMapper {
    public static RelatorioModel toMapper() {
        return new RelatorioModel(
                SistemaService.getSistema(),
                ArmazenamentoService.getArmazenamento(),
                MemoriaRamService.getMemoria(),
                ProcessadorService.getProcessador(),
                PlacaGraficaService.getPlacaGrafica(),
                null,
                BateriaService.getBateria(),
                RedeService.getRede(),
                InternetService.getInternet(),
                DispositivosUsbService.getDispositivos()
        );
    }
}
