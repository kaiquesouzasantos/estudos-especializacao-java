package criacional.factory;

public class Factory {
    /*
    PROPOSITO:
        O Factory Method é um padrão criacional de projeto que fornece uma interface para criar objetos em uma superclasse,
        mas permite que as subclasses alterem o tipo de objetos que serão criados.

    GANHOS:
        - Você evita acoplamentos firmes entre o criador e os produtos concretos.
        - Princípio de responsabilidade única. Você pode mover o código de criação do produto para um único local do programa,
          facilitando a manutenção do código.
        - Princípio aberto/fechado. Você pode introduzir novos tipos de produtos no programa sem quebrar o código cliente existente.

    PERDAS:
        -  O código pode se tornar mais complicado, pois você precisa introduzir muitas subclasses novas para implementar o padrão.
           O melhor cenário é quando você está introduzindo o padrão em uma hierarquia existente de classes criadoras.

    SOLUCAO:
        O padrão Factory Method sugere que você substitua chamadas diretas de construção de objetos (usando o operador new) por
        chamadas para um método fábrica especial. Não se preocupe: os objetos ainda são criados através do operador new,
        mas esse está sendo chamado de dentro do método fábrica.
        Objetos retornados por um método fábrica geralmente são chamados de produtos.
    */

    public static void main(String[] args) {
        MensagemFactory.getMensagem(1).enviar("teste");
        MensagemFactory.getMensagem(2).enviar("teste");
    }
}

class MensagemFactory {
    public static Mensagem getMensagem(int tipo) {
        return tipo == 1 ? new MensagemEmail() : new MensagemSMS();
    }
}

class MensagemSMS implements Mensagem {

    @Override
    public void enviar(String mensagem) {
        System.out.println("SMS: " + mensagem);
    }
}

class MensagemEmail implements Mensagem {

    @Override
    public void enviar(String mensagem) {
        System.out.println("EMAIL: " + mensagem);
    }
}

interface Mensagem {
    void enviar(String mensagem);
}
