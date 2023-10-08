package collectionThreadSafe;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class MeuRunnable implements Runnable {
    /*
     new CopyOnWriteArrayList<>() | realiza uma nova copia da estrutura
     new ConcurrentHashMap<>()
     new LinkedBlockingDeque<>(<limit_size>)

        bloquea o assincronismo (Thread-Safe), porem a cada execucao de manipulacao,
        e sincronizacao, sendo assim, perdendo performace
    */

    public static List<String> lista = new CopyOnWriteArrayList<>();
    public static Map<Integer, String> dicionario = new ConcurrentHashMap<>();
    public static BlockingDeque<String> fila = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        var adicionado = "ELEMENTO";

        lista.add(adicionado);
        fila.add(adicionado);
        dicionario.put(new Random().nextInt(), adicionado);

        System.out.print(Thread.currentThread().getName() + " | ");
    }
}
