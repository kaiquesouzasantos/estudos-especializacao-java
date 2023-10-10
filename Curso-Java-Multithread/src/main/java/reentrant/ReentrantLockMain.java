package reentrant;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {
    private static int contador = -1;
    private static final ReentrantLock lock = new ReentrantLock();

    /*
        ReentrantLock ->
            -  semelhante ao synchronized, onde ele bloqueia o acesso multiplo a um recurso, mas inibido de ser em bloco, ou seja, desacoplamento do funcionamento
            - ele faz uma fila e permite a execucao unitaria

        tryLock() / tryLock(<long>, TimeUnit[unidade]) -> retorna um booleano, informando a tentativa de executar o trecho
    */

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 6; i++) {
            executor.execute(
                    () -> {
                        lock.lock(); // -> permite/impede execucao, baseado no recurso ainda estiver sendo utilizado por outra tarefa
                        contador++;
                        System.out.println(Thread.currentThread().getName() + " : " + contador);
                        lock.unlock(); // -> desbloqueia o recurso
                    }
            );
        }

        executor.shutdown();
    }
}
