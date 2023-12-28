package comportamental.visitor;

public class Visitor {
    /*
    PROPOSITO:
        O Visitor é um padrão de projeto comportamental que permite que você separe algoritmos dos objetos nos quais eles operam.

    GANHOS:
        -  Princípio aberto/fechado. Você pode introduzir um novo comportamento que pode funcionar com objetos de diferentes classes sem mudar essas classes.
        - Princípio de responsabilidade única. Você pode mover múltiplas versões do mesmo comportamento para dentro da mesma classe.
        - Um objeto visitante pode acumular algumas informações úteis enquanto trabalha com vários objetos.
          Isso pode ser interessante quando você quer percorrer algum objeto de estrutura complexa, tais como um objeto árvore, e aplicar o visitante para cada objeto da estrutura.

    PERDAS:
        -  Você precisa atualizar todos os visitantes a cada vez que a classe é adicionada ou removida da hierarquia de elementos.
        - Visitantes podem não ter seu acesso permitido para campos e métodos privados dos elementos que eles deveriam estar trabalhando.

    SOLUCAO:
        - O Visitor é um padrão de projeto comportamental que permite adicionar novos comportamentos à
          hierarquia de classes existente sem alterar nenhum código existente.
        - O padrão de projeto Visitor é utilizado quando você deseja definir uma nova operação para um
          conjunto de classes sem alterar a estrutura dessas classes. Ele separa o algoritmo da estrutura do objeto.


        Element:
            -> É a interface que define a operação aceitar(Visitante visitante).
               Essa operação é chamada pelos elementos concretos (ConcreteElement) para aceitar a visita de um Visitor.
        ConcreteElement:
            -> São as classes concretas que implementam a interface Element. Elas são os objetos específicos que podem aceitar visitantes.
        Visitor:
            -> É a interface que declara os métodos visitar para cada tipo de ConcreteElement.
               O Visitor define as operações que serão realizadas sobre os elementos concretos.
        ConcreteVisitor:
            -> São as classes concretas que implementam a interface Visitor e fornecem a implementação específica para cada tipo de ConcreteElement.
    */

    public static void main(String[] args) {
        ProdutoFisico livro = new ProdutoFisico(500); // 500 gramas
        ProdutoDigital ebook = new ProdutoDigital(10); // 10 megabytes

        CalculadoraCustoEnvio calculadora = new CalculadoraCustoEnvio();

        // Aceitar visitante para calcular custo de envio
        livro.aceitar(calculadora);
        ebook.aceitar(calculadora);

        // Obter o custo total de envio
        double custoTotal = calculadora.getCustoEnvioTotal();

        System.out.println("[RELATORIO] CUSTO TOTAL: R$" + custoTotal);
    }
}

// ConcreteElement (Elemento Concreto)
class ProdutoFisico implements Produto {
    private final double peso;

    public ProdutoFisico(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}

class ProdutoDigital implements Produto {
    private final double tamanho;

    public ProdutoDigital(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getTamanho() {
        return tamanho;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}

// ConcreteVisitor (Visitante Concreto)
class CalculadoraCustoEnvio implements Visitante {
    private double custoEnvioTotal = 0;

    @Override
    public void visitar(ProdutoFisico produtoFisico) {
        custoEnvioTotal += produtoFisico.getPeso() * 0.1; // Custa R$0.10 por grama
    }

    @Override
    public void visitar(ProdutoDigital produtoDigital) {
        custoEnvioTotal += produtoDigital.getTamanho() * 0.05; // Custa R$0.05 por megabyte
    }

    public double getCustoEnvioTotal() {
        return custoEnvioTotal;
    }
}

// Visitor (Visitante)
interface Visitante {
    void visitar(ProdutoFisico produtoFisico);
    void visitar(ProdutoDigital produtoDigital);
}

// Element (Elemento)
interface Produto {
    void aceitar(Visitante visitante);
}
