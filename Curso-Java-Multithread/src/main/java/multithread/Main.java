package multithread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
            - componentes:
                Thread -> class
                Runnable -> interface

            -> instamciocao:
                new Thead(... implements Runnable) ou new Thead(lambda)

            - metodos:
                run() -> oriundo do Runnable, em que e executado no mesmo bloco de processamento(thread)
                start() -> cria uma nova thread na JVM (Java Virtual Machine) e executa o run(), fora do escopo principal
                stop() -> encerra a execucao da thread

             - metodos static:
                sleep(ms) -> atrasa/retarda a execucao de um comando dentro da thread
                currentThread() -> identfica a thread responsavel pela execucao
        */

        System.out.println(Thread.currentThread().getName());
        new Thread(new MeuRunnable()).run();
        new Thread(new MeuRunnable()).start();
        new Thread(() -> System.out.println("EXECUTANDO POR LAMBDA")).start();

        // interrupcao forcada
        Thread thread = new Thread(new MeuRunnableContinuo());
        thread.start();
        Thread.sleep(100);
        thread.stop();
    }
}
