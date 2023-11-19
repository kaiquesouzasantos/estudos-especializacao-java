package mapper;

import model.PlacaGraficaModel;
import oshi.hardware.GraphicsCard;
import oshi.util.FormatUtil;

public class PlacaGraficaMapper {
    public static PlacaGraficaModel toMapper(GraphicsCard graphicsCard) {
        return new PlacaGraficaModel(
                graphicsCard.getName(),
                graphicsCard.getVendor(),
                FormatUtil.formatBytes(graphicsCard.getVRam())
        );
    }
}
