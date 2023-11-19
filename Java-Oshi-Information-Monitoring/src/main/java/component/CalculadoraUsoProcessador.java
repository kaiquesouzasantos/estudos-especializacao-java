package component;

import oshi.hardware.CentralProcessor;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraUsoProcessador {
    private static final List<Double> valoresColetados = new ArrayList<>();
    public static String getMediaPorcentagemUso(CentralProcessor processor) {
        for(int i = 0; i < 5; i++) {
            valoresColetados.add(coletaPorcentagem(processor));
        }

        return formataPorcentagem(valoresColetados.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
    }

    public static String getPorcentagemUso(CentralProcessor processor) {
        return formataPorcentagem(coletaPorcentagem(processor));
    }


    private static double coletaPorcentagem(CentralProcessor processor) {
        try {
            long[] prevTicks = processor.getSystemCpuLoadTicks();
            Thread.sleep(1000);

            return processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100.0;
        } catch (InterruptedException ignored) { }

        return 0.0;
    }

    private static String formataPorcentagem(double valor) {
        return String.format("%.2f", valor).concat("%");
    }
}
