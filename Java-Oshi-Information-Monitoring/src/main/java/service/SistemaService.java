package service;

import component.SystemComponent;
import mapper.SistemaMapper;
import model.SistemaModel;
import oshi.software.os.OperatingSystem;

public class SistemaService {
    public static SistemaModel getSistema() {
        return SistemaMapper.toMapper(getOperatingSystem());
    }

    private static OperatingSystem getOperatingSystem() {
        return SystemComponent.getInstance().getOperatingSystem();
    }
}
