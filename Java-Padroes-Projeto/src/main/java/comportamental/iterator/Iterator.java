package comportamental.iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Iterator {
    /*
    PROPOSITO:
        O Iterator é um padrão de projeto comportamental que permite a você percorrer elementos de uma coleção
        sem expor as representações dele (lista, pilha, árvore, etc.)

    GANHOS:
        - Princípio de responsabilidade única. Você pode limpar o código cliente e as coleções ao extrair os pesados algoritmos de travessia para classes separadas.
        - Princípio aberto/fechado. Você pode implementar novos tipos de coleções e iteradores e passá-los para o código existente sem quebrar coisa alguma.
        - Você pode iterar sobre a mesma coleção em paralelo porque cada objeto iterador contém seu próprio estado de iteração.
        - Pelas mesmas razões, você pode atrasar uma iteração e continuá-la quando necessário.

    PERDAS:
        -  Aplicar o padrão pode ser um preciosismo se sua aplicação só trabalha com coleções simples.
        - Usar um iterador pode ser menos eficiente que percorrer elementos de algumas coleções especializadas diretamente.

    SOLUCAO:
        - O Iterador é um padrão de projeto comportamental que permite a passagem sequencial através de uma estrutura de dados complexa sem expor seus detalhes internos.
        - Graças ao Iterator, os clientes podem examinar elementos de diferentes coleções de maneira semelhante usando uma única interface iterador.
    */
    public static void main(String[] args) {
        VideoIterator videoIterator = new VideoIterator(
                new Video("Guerra Mundial Z"),
                new Video("Sniper Americano"),
                new Video("Tropa de Elite"),
                new Video("Rebel Moon - Parte 1")
        );

        while (videoIterator.hasNext()) {
            System.out.println(videoIterator.next().getNome());
        }
    }
}

class VideoIterator implements Iterador {
    private final Video[] itens;
    private int posicao = 0;

    public VideoIterator(Video ...itens) {
        this.itens = itens;
    }

    @Override
    public Video next() {
        posicao++;
        return itens[posicao - 1];
    }

    @Override
    public boolean hasNext() {
        return !(posicao >= itens.length || itens[posicao] == null);
    }
}

interface Iterador {
    boolean hasNext();
    Video next();
}

@AllArgsConstructor
@Getter
class Video {
    private final String nome;
}