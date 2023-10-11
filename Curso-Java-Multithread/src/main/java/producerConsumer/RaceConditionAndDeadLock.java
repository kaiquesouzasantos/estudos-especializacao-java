package producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceConditionAndDeadLock {
    /*
        Race Conditional -> N threads acessando o mesmo recurso, dado uma depender da acao de outra, demonstrando uma aninhacao na execucao
        DeadLock -> parada das threads, oriundo do Race Conditional
    */

    private static final List<Integer> LISTA = new ArrayList<>(5);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    simulationSleepProcessing();

                    if (!conditional(5)) {
                        LISTA.add(new Random().nextInt(10000));

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
                        LISTA
                                .stream()
                                .findFirst()
                                .ifPresent(LISTA::remove);

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
        return LISTA.size() == valorParada;
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
