package countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static volatile int i = 0;
    private static CountDownLatch latch = new CountDownLatch(3);

    /*
        CountDownLatch
            ->
                - impede a passagem do execucao principal (code-blocked) ate o numero minimo de chamadas await() seja atingido
                - muito semelhante ao cyclicBarreir, porem nao e reutilizavel, ou seja, quando atingido o limite, ele deve ser instanciado novamente
                - varias tarefas distintas podem acessar um mesmo await()

                ### todo comportamento await() no java exige tratamento excepcional
    */

    public static void main(String[] args) {
        var executor = Executors.newScheduledThreadPool(3);

        executor.scheduleAtFixedRate(
                () -> {
                    System.out.println(" I = " + i + " | J = " + new Random().nextInt(1000));
                    latch.countDown();
                },
                0, 1, TimeUnit.SECONDS
        );

        while (true) {
            // o await() so executara as linhas subsequentes, quando seu limite countLatch for atingido
            await();
            i = getRandom();
            latch = getCount();
        }
    }

    private static int getRandom() {
        return new Random().nextInt(100);
    }

    private static CountDownLatch getCount() {
        return new CountDownLatch(3);
    }

    private static void await() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
