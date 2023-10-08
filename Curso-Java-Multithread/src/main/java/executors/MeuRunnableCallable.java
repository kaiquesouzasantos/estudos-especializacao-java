package executors;

import java.util.concurrent.Callable;

public class MeuRunnableCallable implements Callable<String> {
    @Override
    public String call() {
        return "THREAD: " + Thread.currentThread().getName();
    }
}
