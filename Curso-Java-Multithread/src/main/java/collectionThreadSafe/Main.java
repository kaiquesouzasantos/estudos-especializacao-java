package collectionThreadSafe;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();

        Thread.sleep(500);

        System.out.println(MeuRunnable.lista);
        System.out.println(MeuRunnable.fila);
        System.out.println(MeuRunnable.dicionario);
    }
}
