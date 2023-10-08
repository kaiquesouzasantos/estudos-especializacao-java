package volative_yield;

public class MeuRunnableMultiVolative implements Runnable {
    /*
        volative

            quando uma variavel e atribuida, ela tem seu valor armazenado no cache no processador e na memoria RAM,
            onde nem sempre o que esta em armazenado esta sincronizado, ou seja, nem sempre o valor contido no cache e o mesmo da RAM,
            sendo assim, essa palavra reservada indica que o valor sofre mutacao continua e ira ler o valor da atualizacao mais recente na memoria (e nao no cahce)

            - desvantagem: como ele realiza a comparac1ao e deixa de usar o cache, a distancia fisica aumenta, sendo assim, reduz a performace
    */
    public static volatile int numero = 0;
    public static volatile boolean preparado = false;

    public static void setVariables(int numero, boolean preparado) {
        MeuRunnableMultiVolative.numero = numero;
        MeuRunnableMultiVolative.preparado = preparado;
    }

    @Override
    public void run() {
        while (!preparado) {
            Thread.yield();
        }

        if (numero != 50) {
            throw new IllegalStateException("TOMA ESSA EXCEPTION NA BOQUETA");
        }
    }
}
