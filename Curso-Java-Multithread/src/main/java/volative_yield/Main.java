package volative_yield;

import java.util.List;
import java.lang.Thread.State;

public class Main {
    public static void main(String[] args) {
        new Thread(new MeuRunnable()).start();
        MeuRunnable.setVariables(50, true);

        while (true) {
            List<Thread> threadList = List.of(
                    new Thread(new MeuRunnableMultiVolative()),
                    new Thread(new MeuRunnableMultiVolative()),
                    new Thread(new MeuRunnableMultiVolative())
            );

            threadList.forEach(Thread::start);
            MeuRunnableMultiVolative.setVariables(50, true);

            while (
                    threadList.stream().allMatch(
                            value ->  value.getState() != State.TERMINATED
                    )
            ) { }

            MeuRunnableMultiVolative.setVariables(0, false);
        }
    }
}
