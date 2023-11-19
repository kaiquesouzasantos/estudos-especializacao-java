package service;

import component.SystemComponent;
import mapper.ProcessadorMapper;
import model.ProcessadorModel;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;

public class ProcessadorService {
    public static ProcessadorModel getProcessador() {
        return ProcessadorMapper.toMapper(getCentralProcessor(), getSensors());
    }

    private static CentralProcessor getCentralProcessor() {
        return SystemComponent.getInstance().getHardware().getProcessor();
    }

    private static Sensors getSensors() {
        return SystemComponent.getInstance().getHardware().getSensors();
    }
}
