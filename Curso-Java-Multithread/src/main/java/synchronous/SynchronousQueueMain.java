package synchronous;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueMain {
    private static final SynchronousQueue<String> FILA = new SynchronousQueue();

    /*
        SynchronousQueue
        ->
            - lista em estrutura de fila, capaz de suportar o assincronismo da concorrencia
            - muito interresante na transferencia de dados entre threads, dado a sua simplicidade
    */
    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        // para cada 1 put() -> 1 take()
        executor.execute(
                () -> {
                    put("ELEMENTO - 1");
                    put("ELEMENTO - 2");
                    put("ELEMENTO - 3");
                }
        );

        executor.execute(
                () -> {
                    System.out.println(take());
                    System.out.println(take());
                    System.out.println(take());
                }
        );

        executor.shutdown();
    }

    private static void put(String elemento) {
        try {
            /*
                put(<elemento>) -> adiciona um elemento na fila
                offer(<elemento>, <long>, TimeUnit[unidade]) -> adiciona na fila, porem com um limite de tempo para ser resgatado pelo take() ou poll()
            */
            FILA.put(elemento);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static String take() {
        /*
            take() -> retorna e retira da fila o ultimo elemento
            poll(<long>, TimeUnit[unidade]) -> semelhante ao take(), porem com limite de tempo
        */
        try {
            return FILA.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
