package cyclicBarrier;

import java.util.concurrent.*;

public class Main {
    /*
        CyclicBarrier
            ->
                - "todos passam juntos", fundamentalmente, esse componente define que a execucao da finalizacao(runnable) sera executado,
                somente quando o numero de tarefas forem concluidas totalmente
                - apos a finalizacao, o componente continua em execucao, entao ainda pode ser reutiilzado N vezes

    */
    private static final BlockingQueue<Double> resultados = new LinkedBlockingQueue<>(); // -> collection que suporta o assincronismo de acesso

    public static void main(String[] args) {
        /*
            new CyclicBarrier(<numero_chamadas>, <runnable_finalizacao>)
        */
        var cyclic = new CyclicBarrier(
                3,
                () -> {
                    System.out.println(
                            "SOMA: " + resultados.stream().reduce(Double::sum).get()
                    );
                }
        );

        var executor = Executors.newFixedThreadPool(3);

        executor.execute(
                () -> {
                    resultados.add(432d * 3d);
                    await(cyclic);
                    System.out.println("TERMINEI");
                }
        );

        executor.execute(
                () -> {
                    resultados.add(Math.pow(3d, 14d));
                    await(cyclic);
                    System.out.println("TERMINEI");
                }
        );

        executor.execute(
                () -> {
                    resultados.add(45d * 127d / 12d);
                    await(cyclic);
                    System.out.println("TERMINEI");
                }
        );

        executor.shutdown();
    }

    // metodo default
    private static void await(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
