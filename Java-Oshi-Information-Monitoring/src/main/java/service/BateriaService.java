package service;

import component.SystemComponent;
import mapper.BateriaMapper;
import model.BateriaModel;
import oshi.hardware.PowerSource;

public class BateriaService {
    public static BateriaModel getBateria() {
        return BateriaMapper.toMapper(getPowerSource());
    }

    private static PowerSource getPowerSource() {
        return SystemComponent.getInstance().getHardware().getPowerSources().get(0);
    }
}
