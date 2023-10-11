package otherOptions;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class StreamParallelMain {
    public static void main(String[] args) {
        notParallel();
        parallel();
    }

    public static void notParallel() {
        Map<Double, Double> map = new ConcurrentHashMap<>();

        Instant start = Instant.now();
        IntStream.range(1, 10000000)
                .mapToDouble(numero -> Math.pow(numero, 5))
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> map.put(numero, Math.pow(numero, 5)));
        Instant end = Instant.now();

        System.out.println(Duration.between(start, end));
    }

    public static void parallel() {
        Map<Double, Double> map = new ConcurrentHashMap<>();

        Instant start = Instant.now();
        IntStream.range(1, 10000000)
                .parallel() // -> "o que ficar pronto primeiro, continua"
                .mapToDouble(numero -> Math.pow(numero, 5))
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> map.put(numero, Math.pow(numero, 5)));
        Instant end = Instant.now();

        System.out.println(Duration.between(start, end));
    }
}
