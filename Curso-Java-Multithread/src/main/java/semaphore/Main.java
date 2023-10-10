package semaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final Semaphore SEMAFORO = new Semaphore(3);
    private static volatile int contador = 0;
    private static final AtomicInteger esperando = new AtomicInteger(0);

    /*
        Semaphore
            ->
                - limita a quantidade de execucoes simultaneas, onde valida a quantidade de chamadas assincronas e libera a vaga na execucao
                - um tipo de execucao/chamada em blocos, semelhante ao synchronized com definicao N execucoes
    */

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 12; i++) {
            executor.execute(() -> {
                acquire(); // -> controla a continuidade, baseado na quantidade de tarefas executando o trecho com o limite estabelecido

                System.out.println(
                        "EXECUCAO: " + contador + " | THREAD: " + Thread.currentThread().getName()
                );

                sleep();
                SEMAFORO.release(); // -> declara a liberacao da vaga/espaco (conclusao da execucao no trecho)
            });
        }

        for (int i = 0; i < 12; i++) {
            executor.execute(() -> {
                boolean temVaga = tryAcquire();
                esperando.incrementAndGet();

                while (!temVaga)
                    temVaga = tryAcquire();

                esperando.decrementAndGet();

                contador++;
                System.out.println(
                        "EXECUCAO-TRY: " + contador + " | THREAD: " + Thread.currentThread().getName()
                );

                sleep();
                SEMAFORO.release(); // -> declara a liberacao da vaga/espaco (conclusao da execucao no trecho)
            });
        }

        executor.shutdown();
    }

    private static void acquire() {
        getEsperando();
        try {
            SEMAFORO.acquire();
            contador++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static boolean tryAcquire() {
        getEsperando();
        try {
            return SEMAFORO.tryAcquire(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void getEsperando() {
        System.out.println("## ESPERANDO: " + esperando.get()+ " ##");
    }
}
