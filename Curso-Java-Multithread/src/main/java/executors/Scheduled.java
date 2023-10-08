package executors;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Scheduled {
    public static void main(String[] args) {
        var executor = Executors.newScheduledThreadPool(4); // -> cria N threads

        /*
            schedule(runnable/callable, <int_delay>, TimeUnit[unidade]) -> tarefa agendada para ser executado daqui N tempo
        */
        showFuture(
            executor.schedule(new MeuRunnableCallable(), 2, TimeUnit.SECONDS), "Scheduled"
        );

        /*
            scheduleAtFixedRate(runnable, <int_delay>, <int_interval>, TimeUnit[unidade]) ->
                tarefa agendada para ser executado daqui N tempo e em P intervalo, entre execucoes continuas,
                onde se uma tarefa levar:
                    < interval, ele aguarda completar o tempo
                    > interval, ele executa de acordo com o intervalo, nao aguardando ser concluida
        */
        showFuture(
                executor.scheduleAtFixedRate(new MeuRunnable(), 0, 1, TimeUnit.SECONDS), "Scheduled With Rate"
        );

        /*
            scheduleWithFixedDelay(runnable, <int_delay>, <int_interval>, TimeUnit[unidade]) ->
                tarefa agendada para ser executado daqui N tempo e em P intervalo, entre execucoes continuas,
                onde ele aguarda a tarefa ser executada, para iniciar a proxima
        */
        showFuture(
                executor.scheduleWithFixedDelay(new MeuRunnable(), 0, 1, TimeUnit.SECONDS), "Scheduled With Fixed Delay"
        );
    }

    private static void showFuture(Future<?> future, String tipo) {
        try {
            System.out.println("- " + tipo + " | " + future.get());
        } catch (Exception ignored) {}
    }
}
