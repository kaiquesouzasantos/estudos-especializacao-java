package comportamental.chainOfResponsability;

public class ChainOfResponsability {
    /*
    PROPOSITO:
        O Chain of Responsibility é um padrão de projeto comportamental que permite que você passe pedidos por uma corrente de handlers. 
        Ao receber um pedido, cada handler decide se processa o pedido ou o passa adiante para o próximo handler na corrente.

    GANHOS:
        - Você pode controlar a ordem de tratamento dos pedidos.
        - Princípio de responsabilidade única. Você pode desacoplar classes que invocam operações de classes que realizam operações.
        - Princípio aberto/fechado. Você pode introduzir novos handlers na aplicação sem quebrar o código cliente existente.

    PERDAS:
        - Alguns pedidos podem acabar sem tratamento.

    SOLUCAO:
        - O Chain of Responsibility é um padrão de projeto comportamental que permite passar a solicitação ao longo da cadeia
          de handlers em potencial até que um deles lide com a solicitação.
        - O padrão permite que vários objetos tratem a solicitação sem acoplar a classe remetente às classes concretas dos destinatários.
          A cadeia pode ser composta dinamicamente em tempo de execução com qualquer handler que siga uma interface de handler padrão.
    */

    public static void main(String[] args) {
        Aprovador presidente = new PresidenteAprovador();
        Aprovador diretor = new DiretorAprovador(presidente);
        Aprovador gerente = new GerenteAprovador(diretor);

        gerente.aprovarPedido(500.0);
        gerente.aprovarPedido(2500.0);
        gerente.aprovarPedido(10000.0);
    }
}

// Handler (Manipulador)
abstract class Aprovador {
    protected Aprovador proximoAprovador;

    public abstract void aprovarPedido(double valor);

    protected void relatorioPedido(String mensagem) {
        System.out.println(mensagem);
    }
}

// ConcreteHandler (Manipulador Concreto)
class GerenteAprovador extends Aprovador {
    private final double limite_aprovacao;

    public GerenteAprovador(Aprovador proximoAprovador) {
        this.limite_aprovacao = 1000.0;
        super.proximoAprovador = proximoAprovador;
    }

    @Override
    public void aprovarPedido(double valor) {
        if (valor <= limite_aprovacao) {
            relatorioPedido("PEDIDO [APROVADO] POR: GERENTE | NO VALOR DE R$" + valor);
        } else if (proximoAprovador != null) {
            relatorioPedido("PEDIDO [TRANFERIDO] POR: GERENTE | NO VALOR DE R$" + valor);
            proximoAprovador.aprovarPedido(valor);
        } else {
            relatorioPedido("PEDIDO [REPROVADO] POR: GERENTE");
        }
    }
}

class DiretorAprovador extends Aprovador {
    private final double limite_aprovacao;

    public DiretorAprovador(Aprovador proximoAprovador) {
        this.limite_aprovacao = 5000.0;
        super.proximoAprovador = proximoAprovador;
    }

    @Override
    public void aprovarPedido(double valor) {
        if (valor <= limite_aprovacao) {
            relatorioPedido("PEDIDO [APROVADO] POR: DIRETOR | NO VALOR DE R$" + valor);
        } else if (proximoAprovador != null) {
            relatorioPedido("PEDIDO [TRANFERIDO] POR: DIRETOR | NO VALOR DE R$" + valor);
            proximoAprovador.aprovarPedido(valor);
        } else {
            relatorioPedido("PEDIDO [REPROVADO] POR: DIRETOR");
        }
    }
}

class PresidenteAprovador extends Aprovador {
    @Override
    public void aprovarPedido(double valor) {
        relatorioPedido("PEDIDO [APROVADO] POR: PRESIDENTE | NO VALOR DE R$" + valor);
    }
}
