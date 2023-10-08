package executors;

import java.util.concurrent.*;

public class SingleThread {
    /*
        Executors
            .newSingleThreadExecutor() -> cria uma thread para execucao de N runnables

        -> um executor e capaz de executar N runnables (diferentes ou iguais) e simultaneas, em uma mesma instancia

        - metodos:
            execute(runnable) -> executa o runnable de maneira continua, ou seja, apos o fim da execucao do componente, ele nao finaliza o programa
            submit(runnable) -> similar ao execute(), porem retorna um Future
            awaitTermination(<long>, TimeUnit.[unidade_tempo]) -> "termine a tafera ate x tempo", limitador de timeout
            shutdown() -> encerra a execucao da tarefa calmamente, mas nao permite que o executor realize mais nenhuma tarefa
            shutdownNow() -> encera de forma drastica ("botao de desligar")
    */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        executorSimple();
        executorWithFuture();
        executorWithCallable();
    }

    private static void executorSimple() throws InterruptedException {
        var executor = getExecutor();

        executor.execute(new MeuRunnable());
        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown();
    }

    private static void executorWithFuture() throws InterruptedException {
        var executor = getExecutor();

        Future<?> future = executor.submit(new MeuRunnable());
        showFuture(future);

        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);

        showFuture(future);
    }

    private static void executorWithCallable() throws InterruptedException, ExecutionException, TimeoutException {
        var executor = getExecutor();

        /*
            o Future em conjunto com o Callable, reduzem a complexidade de aplicacao,
            onde quando submetido a execucao da tarefa, o metodo do callble retorna um valor,
            em que o future.get() aguarda a execucao, para acessa-lo

            Future

                -metodos:

                isDone() -> retorna um booleano informando se a execucao esta concluida
                get() -> retorna o valor retornado pela execucao, quando estiver disponivel
                get(<long>, TimeUnit[unidade]) -> limita o tempo de espera para o retorno
        */
        Future<String> future = executor.submit(new MeuRunnableCallable());

        System.out.println(future.isDone());
        // System.out.println(future.get());
        System.out.println(future.get(1, TimeUnit.SECONDS));
        System.out.println(future.isDone());
    }

    private static ExecutorService getExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    private static void showFuture(Future<?> future) {
        System.out.print(" | " + future.isDone());
    }
}
