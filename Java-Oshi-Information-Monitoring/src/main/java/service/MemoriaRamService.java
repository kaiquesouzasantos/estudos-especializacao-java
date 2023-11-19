package service;

import component.SystemComponent;
import mapper.MemoriaRamMapper;
import model.MemoriaRamModel;
import oshi.hardware.GlobalMemory;

public class MemoriaRamService {
    public static MemoriaRamModel getMemoria() {
        return MemoriaRamMapper.toMapper(getGlobalMemory());
    }

    private static GlobalMemory getGlobalMemory() {
        return SystemComponent.getInstance().getHardware().getMemory();
    }
}
