package classAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MeuRunnable implements Runnable {
    /*
        Atomic[wrapper]
        AtomicReference<[object]>

            implementacao que executa a modificao da estrutura na camada de baixo nivel,
            nao sendo possivel ser interrompida, realizando uma pseudo-sincronia performatica
    */

    private static final AtomicInteger contador = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + contador.incrementAndGet());
    }
}