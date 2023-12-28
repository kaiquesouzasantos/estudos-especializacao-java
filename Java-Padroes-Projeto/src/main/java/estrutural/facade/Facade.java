package estrutural.facade;

public class Facade {
    /*
    PROPOSITO:
        O Facade é um padrão de projeto estrutural que fornece uma interface simplificada para uma biblioteca,
        um framework, ou qualquer conjunto complexo de classes.

    GANHOS:
        - Você pode isolar seu código da complexidade de um subsistema.

    PERDAS:
        - Uma fachada pode se tornar um objeto deus acoplado a todas as classes de uma aplicação.

    SOLUCAO:
        - Uma fachada é uma classe que fornece uma interface simples para um subsistema complexo que contém muitas partes que se movem.
          Uma fachada pode fornecer funcionalidades limitadas em comparação com trabalhar com os subsistemas diretamente.
          Contudo, ela inclui apenas aquelas funcionalidades que o cliente se importa.
        - Ter uma fachada é útil quando você precisa integrar sua aplicação com uma biblioteca sofisticada que tem dúzias de funcionalidades,
          mas você precisa de apenas um pouquinho delas.
    */

    public static void main(String[] args) {
        ComputadorFacade computador = new ComputadorFacade();
        computador.montarComputador();

        System.out.println(computador);
    }
}

class ComputadorFacade {
    private Memoria memoria;
    private HD hd;
    private CPU cpu;
    private SO so;

    public void montarComputador() {
        this.memoria = new Memoria(8.0);
        this.hd = new HD(500.0);
        this.cpu = new CPU(3.1);
        this.so = new SO("Windows 10 Home");
    }

    @Override
    public String toString() {
        return "ComputadorFacade{" +
                "memoria=" + memoria +
                ", hd=" + hd +
                ", cpu=" + cpu +
                ", so=" + so +
                '}';
    }
}

record Memoria(double ram){}
record HD(double capacidade){}
record CPU(double GHz){}
record SO(String modelo){}
