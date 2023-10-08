package concurrency;

public class Main {
    public static void main(String[] args) {
        /*
            em caso de multiplo acesso simultaneo a um recurso, nao existe garantia de execucao,
            dado o processador depender de N fatores externos na priorizacao,
            sendo assim, ocasionando que durante a execucao X, o recurso seja alterado pela execucao X+1, afetando X
            entao o uso da palavra reservada synchronized permite assegurar que as N execucoes simultaneas
            acessaram o recurso de maneira ordenada e nao simultanea (stack), ou seja, funciona como bloqueador de concorrencia
        */

        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
        new Thread(new MeuRunnable()).start();
    }
}
