package volative_yield;

public class MeuRunnable implements Runnable {
    public static int numero;
    public static boolean preparado;

    public static void setVariables(int numero, boolean preparado) {
        MeuRunnable.numero = numero;
        MeuRunnable.preparado = preparado;
    }

    @Override
    public void run() {
        /*
            Thread.yield()

                informa ao processador que nao tem nada para executar momentaneamente,
                e sugere que seu espaco alocado seja utilizado em outros recuros/tarefas
        */

        while (!preparado) {
            Thread.yield();
        }

        System.out.print(numero);
    }
}
