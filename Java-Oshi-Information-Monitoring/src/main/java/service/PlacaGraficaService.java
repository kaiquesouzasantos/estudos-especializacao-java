package service;

import component.SystemComponent;
import mapper.PlacaGraficaMapper;
import model.PlacaGraficaModel;
import oshi.hardware.GraphicsCard;

public class PlacaGraficaService {
    public static PlacaGraficaModel getPlacaGrafica() {
        return PlacaGraficaMapper.toMapper(getGraphicsCard());
    }

    private static GraphicsCard getGraphicsCard() {
        return SystemComponent.getInstance().getHardware().getGraphicsCards().get(0);
    }
}
