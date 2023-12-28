package criacional.prototype;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    /*
    PROPOSITO:
        O Prototype é um padrão de projeto criacional que permite copiar objetos existentes sem fazer seu código ficar dependente de suas classes.

    GANHOS:
        - Você pode clonar objetos sem acoplá-los a suas classes concretas.
        - Você pode se livrar de códigos de inicialização repetidos em troca de clonar protótipos pré-construídos.
        - Você pode produzir objetos complexos mais convenientemente.
        - Você tem uma alternativa para herança quando lidar com configurações pré determinadas para objetos complexos.

    PERDAS:
        -  Clonar objetos complexos que têm referências circulares pode ser bem complicado.

    SOLUCAO:
        Todas as classes de prototypes(protótipos) devem ter uma interface comum que permita copiar objetos,
        mesmo que suas classes concretas sejam desconhecidas.
        Objetos protótipos podem produzir cópias completas, pois objetos da mesma classe podem acessar os campos privados um do outro.
    */

    private static List<Forma> formas = new ArrayList<>(), formasCopiadas = new ArrayList<>();

    public static void main(String[] args) {
        formas.add(
                new Circulo(10)
        );

        formas.add(
                new Retangulo(15, 10)
        );

        clonaCompara();
    }

    private static void clonaCompara() {
        formas.forEach(
                forma -> formasCopiadas.add(forma.clone())
        );

        for (int posicao = 0; posicao < formas.size(); posicao++) {
            if (formas.get(posicao) != formasCopiadas.get(posicao)) {
                System.out.println("POSICAO: " + posicao + " | SAO OBJETOS DIFERENTES");

                if (formas.get(posicao).equals(formasCopiadas.get(posicao))) {
                    System.out.println("POSICAO: " + posicao + " | E UM OBJETO IDENTICO");
                } else {
                    System.out.println("POSICAO: " + posicao + " | NAO E UM OBJETO IDENTICO");
                }
            } else {
                System.out.println("POSICAO: " + posicao + " | SAO O MESMO OBJETO");
            }
        }
    }
}

@Data
class Circulo extends Forma {
    private int raio;

    public Circulo(int raio) {
        this.raio = raio;
    }

    public Circulo(Circulo circulo) {
        super(circulo);
    }

    @Override
    public Forma clone() {
        return new Circulo(this);
    }
}

@Data
class Retangulo extends Forma {
    private int altura, largura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public Retangulo(Retangulo retangulo) {
        super(retangulo);
    }

    @Override
    public Forma clone() {
        return new Retangulo(this);
    }
}

@Data
@NoArgsConstructor
abstract class Forma {
    private String cor;

    public Forma(Forma objeto) {
        if(objeto != null) {
            this.cor = objeto.getCor();
        }
    }
    public abstract Forma clone();
}
