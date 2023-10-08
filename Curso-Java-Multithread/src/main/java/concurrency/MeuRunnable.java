package concurrency;

public class MeuRunnable implements Runnable {
    private static int contador = 0;

    /*
        - limitacao de execucao em um metodo

            [...] synchronized [...]() {
                // code-block
            }

        - limitacao de execucao em um bloco, ou seja, parte sofre concorrencia e outra segue a execycao sincrona

            [...]() {
                // code-block
                synchronized(this/class.class) {
                    // code-block
                }
            }
    */

    @Override
    public void run() {
        int valor;

        /*
            e possivel observar que, somente o trecho que ocorre mutacao esta sincrono,
            pois se torna somente relevante controlar trechos criticos ou volateis,
            interferindo o minimo possivel no assincronismo e administrando devidamente o recurso disputado
        */

        synchronized (this) {
            contador++;
            valor = contador * 2;
        }

        System.out.println(Math.sqrt(Math.pow(valor, 100)));
    }
}
