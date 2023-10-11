package producerConsumer;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CorrectTool {
    private static final LinkedBlockingQueue<Integer> FILA = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {
        Runnable produtor = () -> {
            simulationSleepProcessing(400);

            int numero = new Random().nextInt(10000);

            try {
                FILA.put(numero); // -> adiciona o valor somente com espaco(size), senao ele aguarda a liberacao
                System.out.println("+ produzindo: " + numero);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Runnable consumidor = () -> {
            simulationSleepProcessing(40);

            try {
                System.out.println("- consumindo: " + FILA.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        var executor = Executors.newScheduledThreadPool(2);

        executor.scheduleWithFixedDelay(produtor, 0, 10, TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(consumidor, 0, 10, TimeUnit.MILLISECONDS);
    }

    private static void simulationSleepProcessing(int time) {
        int tempo = new Random().nextInt(time);

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
