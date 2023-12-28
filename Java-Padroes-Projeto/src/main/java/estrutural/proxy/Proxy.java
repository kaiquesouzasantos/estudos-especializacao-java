package estrutural.proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Proxy {
    /*
    PROPOSITO:
        O Proxy é um padrão de projeto estrutural que permite que você forneça um substituto ou um espaço reservado para outro objeto.
        Um proxy controla o acesso ao objeto original, permitindo que você faça algo ou antes ou depois do pedido chegar ao objeto original.

    GANHOS:
        - Você pode controlar o objeto do serviço sem os clientes ficarem sabendo.
        - Você pode gerenciar o ciclo de vida de um objeto do serviço quando os clientes não se importam mais com ele.
        - O proxy trabalha até mesmo se o objeto do serviço ainda não está pronto ou disponível.
        - Princípio aberto/fechado. Você pode introduzir novos proxies sem mudar o serviço ou clientes.

    PERDAS:
        - O código pode ficar mais complicado uma vez que você precisa introduzir uma série de novas classes.
        - A resposta de um serviço pode ter atrasos.

    SOLUCAO:
        - O Proxy é um padrão de projeto estrutural que fornece um objeto que atua como um substituto para um objeto de serviço real usado por um cliente.
        - Um proxy recebe solicitações do cliente, realiza alguma tarefa (controle de acesso, armazenamento em cache etc.) e passa a solicitação para um objeto de serviço.
    */

    public static void main(String[] args) {
        new LogMensagem().enviar();
    }
}

class LogMensagem extends Mensagem {
    @Override
    public void enviar() {
        System.out.println("ETAPA: LOG | " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        super.enviar();
    }
}

class Mensagem {
    public void enviar() {
        System.out.println("ETAPA: ENVIO DE MENSAGEM");
    }
}

