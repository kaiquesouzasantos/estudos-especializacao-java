package producerConsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalSectionAndMutex {
    /*
        Critical Section -> regiao de concorrencia, ou seja, local do codigo onde as threads se referem a um recurso compartilhado
        Mutex ->
            -   em casos de troca de informacao entre threads, atraves de um recurso,
                onde um modifica e outro consome, e possivel que uma consuma o recurso sem antes o valor ser modificado,
                sendo tipico da concorrencia, entao o mutex e a protecao, onde um consome somente apos a modificacao
    */

    private static final LinkedBlockingQueue<Integer> FILA = new LinkedBlockingQueue<>(5);
    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    simulationSleepProcessing();

                    if (!conditional(5)) {
                        LOCK.lock();
                        FILA.add(new Random().nextInt(10000));
                        LOCK.unlock();

                        if (conditional(5)) {
                            System.out.println("--- Pausando produtor");
                        } else {
                            System.out.println("+++ Iniciando consumidor");
                        }

                    } else {
                        System.out.println("--> Produtor dormindo");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    simulationSleepProcessing();

                    if (!conditional(0)) {
                        LOCK.lock();
                        FILA
                                .stream()
                                .findFirst()
                                .ifPresent(FILA::remove);
                        LOCK.unlock();

                        if (conditional(0)) {
                            System.out.println("--- Pausando consumidor");
                        } else {
                            System.out.println("+++ Iniciando produtor");
                        }

                    } else {
                        System.out.println("--> Consumidor dormindo");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    private static boolean conditional(int valorParada) {
        return FILA.size() == valorParada;
    }

    private static void simulationSleepProcessing() {
        int tempo = new Random().nextInt(40);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
