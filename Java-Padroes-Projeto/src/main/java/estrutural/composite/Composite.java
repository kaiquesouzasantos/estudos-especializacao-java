package estrutural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    /*
    PROPOSITO:
        O Composite é um padrão de projeto estrutural que permite que você componha objetos em estruturas de
        árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.

    GANHOS:
        - Você pode trabalhar com estruturas de árvore complexas mais convenientemente: utilize o polimorfismo e a recursão a seu favor.
        - Princípio aberto/fechado. Você pode introduzir novos tipos de elemento na aplicação sem quebrar o código existente,
          o que agora funciona com a árvore de objetos.

    PERDAS:
        - Pode ser difícil providenciar uma interface comum para classes cuja funcionalidade difere muito.
          Em certos cenários, você precisaria generalizar muito a interface componente, fazendo dela uma interface de difícil compreensão.

    SOLUCAO:
        O Composite se tornou uma solução bastante popular para a maioria dos problemas que exigem a construção de uma estrutura em árvore.
        O grande recurso do Composite é a capacidade de executar métodos recursivamente em toda a estrutura da árvore e resumir os resultados.
    */

    public static void main(String[] args) {
        Lista formas = new Lista();

        var circulo = new Circulo(4);
        formas.adiciona(circulo);

        formas.adiciona(new Circulo(10));
        formas.adiciona(new Retangulo(15,12));

        formas.remove(circulo);
        formas.exibe();
    }
}

class Lista {
    private final List<Forma> elementos = new ArrayList<>();

    public void adiciona(Forma elemento) {
        elementos.add(elemento);
    }

    public void remove(Forma elemento) {
        elementos.remove(elemento);
    }

    public void exibe() {
        elementos.forEach(
                elemento -> System.out.println(elemento.getArea())
        );
    }
}

class Circulo implements Forma {
    private final int raio;

    public Circulo(int raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return 3.14 * (raio * raio);
    }
}

class Retangulo implements Forma {
    private final int altura, largura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double getArea() {
        return altura * largura;
    }
}

interface Forma {
    double getArea();
}