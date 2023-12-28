package estrutural.bridge;

import lombok.Data;

public class Bridge {
    /*
    PROPOSITO:
        O Bridge é um padrão de projeto estrutural que permite que você divida uma classe grande ou um conjunto de classes intimamente ligadas
         em duas hierarquias separadas—abstração e implementação—que podem ser desenvolvidas independentemente umas das outras.

    GANHOS:
        - Você pode criar classes e aplicações independentes de plataforma.
        - O código cliente trabalha com abstrações em alto nível. Ele não fica exposto a detalhes de plataforma.
        - Princípio aberto/fechado. Você pode introduzir novas abstrações e implementações independentemente uma das outras.
        - Princípio de responsabilidade única. Você pode focar na lógica de alto nível na abstração e em detalhes de plataforma na implementação.

    PERDAS:
        -  Você pode tornar o código mais complicado ao aplicar o padrão em uma classe altamente coesa.

    SOLUCAO:
        - Uma dessas hierarquias (geralmente chamada de Abstração/abstract) obterá uma referência a um objeto da segunda hierarquia (Implementação/interface).
          A abstração poderá delegar algumas (às vezes, a maioria) de suas chamadas para o objeto de implementações.
          Como todas as implementações terão uma interface comum, elas seriam intercambiáveis dentro da abstração.
        - Basicamente, uma classe abstrata possui a referencia a uma interface, que por usa vez, comporta as principais funcoes.
          Onde as subclasses da abstracao comportam o refinamento da implementacao, assim como as implementacoes da interface.
    */

    public static void main(String[] args) {
        new Samsung(new ControleRemotoSamsung()).ligado();
    }
}

class Samsung extends Televisao {
    public Samsung(ControleRemoto controleRemoto) {
        super(controleRemoto);
    }

    @Override
    void ligado() {
        getControleRemoto().ligado();
    }

    @Override
    void desligado() {
        getControleRemoto().desligado();
    }
}

class ControleRemotoSamsung implements ControleRemoto {
    @Override
    public void ligado() {
        System.out.println("SAMSUNG: LIGADO");
    }

    @Override
    public void desligado() {
        System.out.println("SAMSUNG: DESLIGADO");
    }
}

@Data
abstract class Televisao {
    private final ControleRemoto controleRemoto;

    public Televisao(ControleRemoto controleRemoto) {
        this.controleRemoto = controleRemoto;
    }

    abstract void ligado();
    abstract void desligado();
}

interface ControleRemoto {
    void ligado();
    void desligado();
}
