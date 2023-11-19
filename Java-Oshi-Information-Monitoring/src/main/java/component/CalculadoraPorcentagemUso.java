package component;

public class CalculadoraPorcentagemUso {
    public static String getPorcentagemUso(long total, long usado) {
        return String.format("%.2f", ((double) usado / (double) total) * 100).concat("%");
    }
}
