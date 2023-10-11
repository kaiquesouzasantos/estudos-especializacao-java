package otherOptions;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {
    public static void main(String[] args) {
        // CompletableFuture -> sera completado no futuro (incompleto temporariamente)
        CompletableFuture<String> processe = process();

        CompletableFuture<String> thenApply =
                processe.thenApply(value -> value.concat(" 2"));

        thenApply.thenAccept(System.out::println);

        System.out.println("TUDO CERTO");

        sleep();
        sleep();
    }

    private static CompletableFuture<String> process() {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return "1 >";
        });
    }

    private static final void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
