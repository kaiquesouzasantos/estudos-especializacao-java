package classAtomic;

public class Main {
    public static void main(String[] args) {
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
    }
}
