package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeuRunnable implements Runnable {
    /*
        - Collections.synchronized[Map/Set/List/Collection](...)

        a colecao nao esta preparada para o acesso concorrente, devido a isso,
        essa implementacao modifica a estrutura para realizar a limitacao,
        sendo a sua principal vantegem, a garantia que toda a estrutura seja protegida,
        nao se limitando a um metodo acessor
    */

    public static List<String> lista = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {
        lista.add("ELEMENTO");
        System.out.print(Thread.currentThread().getName() + " | ");
    }
}
