package synchronous;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class ExchangerMain {
    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    /*
        Exchanger
        ->
            - ele realiza a troca de valores entre threads,
              onde um exchange() chamado em uma thread N, tem sua informacao exibida em um exchange() da thread Y (assim como Y -> N)
    */
    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        executor.execute(
                () -> {
                    System.out.println(
                            "| ESCREVEU: " + getThread() + " | "
                                    + exchenger("ELEMENTO - 1")
                                    + " | IMPRIMIU: " + getThread()
                    );
                }
        );

        executor.execute(
                () -> {
                    System.out.println(
                            "| ESCREVEU: " + getThread() + " | "
                            + exchenger("ELEMENTO - 2")
                            + " | IMPRIMIU: " + getThread()
                    );
                }
        );

        executor.shutdown();
    }

    private static String exchenger(String elemento) {
        try {
            return EXCHANGER.exchange(elemento);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static String getThread() {
        return Thread.currentThread().getName();
    }
}
