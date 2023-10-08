package executors;

public class MeuRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("-> " +Thread.currentThread().getName());
    }
}
