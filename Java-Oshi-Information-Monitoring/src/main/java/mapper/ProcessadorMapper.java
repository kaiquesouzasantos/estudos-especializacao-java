package mapper;

import component.CalculadoraUsoProcessador;
import model.ProcessadorModel;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;
import oshi.util.FormatUtil;

import java.util.Arrays;

public class ProcessadorMapper {
    public static ProcessadorModel toMapper(CentralProcessor centralProcessor, Sensors sensors) {
        return new ProcessadorModel(
                centralProcessor.getProcessorIdentifier().getName(),
                centralProcessor.getProcessorIdentifier().getVendor(),
                centralProcessor.getProcessorIdentifier().getMicroarchitecture(),
                getArquitetura(centralProcessor.getProcessorIdentifier().isCpu64bit()),
                sensors.getCpuTemperature() + " °C",
                sensors.getCpuVoltage() + " V",
                 FormatUtil.formatHertz(centralProcessor.getProcessorIdentifier().getVendorFreq()),
                Arrays.toString(sensors.getFanSpeeds()) + " RPM",
                CalculadoraUsoProcessador.getPorcentagemUso(centralProcessor),
                CalculadoraUsoProcessador.getMediaPorcentagemUso(centralProcessor),
                centralProcessor.getPhysicalProcessorCount(),
                centralProcessor.getLogicalProcessorCount()
        );
    }

    private static String getArquitetura(boolean is64bit) {
        return is64bit ? "64 bit" : "32 bit";
    }
}
