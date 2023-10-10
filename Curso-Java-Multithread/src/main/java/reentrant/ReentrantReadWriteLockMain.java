package reentrant;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockMain {
    private static int contador = -1;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /*
        ReentrantReadWriteLock:
            writeLock() -> aguarda todos os acessos ao recurso finalizaram(ele tambem impede a interrupcao), e posteriormente realiza a alteracao
            readLock() -> aguarda todos os acessos de mutacao(write) finalizarem(e tambem impede a mutacao durante a leitura), para realizar a leitura
    */

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 6; i++) {
            executor.execute(
                    () -> {
                        lock.writeLock();
                        contador++;
                        System.out.println(Thread.currentThread().getName() + " : " + contador);
                    }
            );
        }

        executor.shutdown();
    }
}
