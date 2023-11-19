package mapper;

import component.CalculadoraPorcentagemUso;
import model.BateriaModel;
import oshi.hardware.PowerSource;

public class BateriaMapper {
    public static BateriaModel toMapper(PowerSource powerSource) {
        return new BateriaModel(
                powerSource.getPowerUsageRate() + " mW",
                powerSource.getVoltage() + " V",
                powerSource.getAmperage() + " mA",
                powerSource.getCurrentCapacity() + " MVH",
                powerSource.getMaxCapacity() + " MVH",
                CalculadoraPorcentagemUso.getPorcentagemUso(powerSource.getMaxCapacity(), powerSource.getCurrentCapacity()),
                powerSource.getTemperature() + " C",
                powerSource.isPowerOnLine(),
                powerSource.isCharging(),
                powerSource.isDischarging()
        );
    }

}
