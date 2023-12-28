package estrutural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

public class Flyweight {
    /*
    PROPOSITO:
        O Flyweight é um padrão de projeto estrutural que permite a você colocar mais objetos na quantidade de RAM disponível ao compartilhar
        partes comuns de estado entre os múltiplos objetos ao invés de manter todos os dados em cada objeto.

    GANHOS:
        -  Você pode economizar muita RAM, desde que seu programa tenha muitos objetos similares.

    PERDAS:
        - Você pode estar trocando RAM por ciclos de CPU quando parte dos dados de contexto precisa ser recalculado cada vez que alguém chama um
          método flyweight.
        - O código fica muito mais complicado. Novos membros de equipe sempre se perguntarão por que o estado de uma entidade foi separado de tal forma.

    SOLUCAO:
        - O padrão consegue isso compartilhando partes do estado do objeto entre vários objetos. Em outras palavras, o
          Flyweight economiza RAM armazenando em cache os mesmos dados usados por objetos diferentes.
    */

    public static void main(String[] args) {
        System.out.println(VeiculoFactory.veiculos);
        System.out.println(VeiculoFactory.getVeiculo("Carro"));

        System.out.println(VeiculoFactory.veiculos);
        System.out.println(VeiculoFactory.getVeiculo("Caminhao"));

        // como observado, objetos semelhantes na composicao nao sao criados novamente, uma vez que ja estao em memoria
        System.out.println(VeiculoFactory.veiculos);
        System.out.println(VeiculoFactory.getVeiculo("Caminhao"));

        System.out.println(VeiculoFactory.veiculos);
        System.out.println(VeiculoFactory.getVeiculo("Moto"));
    }
}

class VeiculoFactory {
    public static final HashMap<String, Veiculo> veiculos = new HashMap<>();

    public static Veiculo getVeiculo(String tipo) {
        if(!veiculos.containsKey(tipo)) {
            switch (tipo) {
                case "Carro":
                    veiculos.put(tipo, new Carro());
                    break;
                case "Caminhao":
                    veiculos.put(tipo, new Caminhao());
                    break;
                default:
                    throw new IllegalArgumentException("TIPO INEXPERADO PARA A CRIACAO");
            }
        }

        return veiculos.get(tipo);
    }
}

class Carro extends Veiculo {
    public Carro() {
        super("CARRO", "180 km/h");
    }
}

class Caminhao extends Veiculo {
    public Caminhao() {
        super("CAMINHAO", "150 km/h");
    }
}

@AllArgsConstructor
class Veiculo {
    private String tipo, velocidade;

    @Override
    public String toString() {
        return
                "TIPO: '" + tipo + " - VELOCIDADE MAXIMA: '" + velocidade;
    }
}
