package executors;

import java.util.List;
import java.util.concurrent.*;

public class MultiThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(4); // -> cria N threads
        var executor_cached = Executors.newCachedThreadPool(); // -> reutiliza as threads com as tasks ja finalizadas e nao possui limitacao de criacao

        for (int contador = 0; contador < 4; contador++) {
            showFuture(executor.submit(new MeuRunnableCallable()), "Fixed");
            showFuture(executor_cached.submit(new MeuRunnableCallable()), "Cached");
        }

        executor.shutdown();

        /*
            invokeAll(<list>) -> executa simultaneamente as tarefas e retorna uma lista Future respectiva ao retorno das tarefas
            invokeAny(<list>) -> executa as tarefas e retorna o resultado da primeira tarefa finalizada
        */

        executor_cached.invokeAll(List.of(
                new MeuRunnableCallable(), new MeuRunnableCallable(), new MeuRunnableCallable(), new MeuRunnableCallable()
        )).forEach(valor -> showFuture(valor, "List"));

        System.out.println(executor_cached.invokeAny(List.of(
                new MeuRunnableCallable(), new MeuRunnableCallable(), new MeuRunnableCallable(), new MeuRunnableCallable()
        )));
    }

    private static void showFuture(Future<?> future, String tipo) {
        try {
            System.out.println("- " + tipo + " | " + future.get());
        } catch (Exception ignored) {}
    }
}
