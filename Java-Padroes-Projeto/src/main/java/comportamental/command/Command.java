package comportamental.command;

public class Command {
    /*
    PROPOSITO:
        O Command é um padrão de projeto comportamental que transforma um pedido em um objeto independente que contém toda a informação sobre o pedido.
        Essa transformação permite que você parametrize métodos com diferentes pedidos, atrase ou coloque a execução do pedido em uma fila,
        e suporte operações que não podem ser feitas.

    GANHOS:
        - Princípio de responsabilidade única. Você pode desacoplar classes que invocam operações de classes que fazem essas operações.
        - Princípio aberto/fechado. Você pode introduzir novos comandos na aplicação sem quebrar o código cliente existente.
        - Você pode implementar desfazer/refazer.
        - Você pode implementar a execução adiada de operações.
        - Você pode montar um conjunto de comandos simples em um complexo.

    PERDAS:
        -  O código pode ficar mais complicado uma vez que você está introduzindo uma nova camada entre remetentes e destinatários.

    SOLUCAO:
        - O Command é um padrão de projeto comportamental que converte solicitações ou operações simples em objetos.
        - A conversão permite a execução adiada ou remota de comandos, armazenamento do histórico de comandos, etc.
    */

    public static void main(String[] args) {
        Televisao televisao = new Televisao();
        ControleRemoto controle = new ControleRemoto();

        controle.setComando(new LigarCommand(televisao));
        controle.pressionarBotao();

        controle.setComando(new AumentarVolumeCommand(televisao));
        controle.pressionarBotao();

        controle.setComando(new DiminuirVolumeCommand(televisao));
        controle.pressionarBotao();

        controle.setComando(new DesligarCommand(televisao));
        controle.pressionarBotao();
    }
}

// Interface(pode ser abstrato) Command
interface Comando {
    void executar();
}

// Classes concretas que implementam Command
class LigarCommand implements Comando {
    private final Televisao televisao;

    public LigarCommand(Televisao televisao) {
        this.televisao = televisao;
    }

    @Override
    public void executar() {
        televisao.ligarLayout();
    }
}

class DesligarCommand implements Comando {
    private final Televisao televisao;

    public DesligarCommand(Televisao televisao) {
        this.televisao = televisao;
    }

    @Override
    public void executar() {
        televisao.desligarLayout();
    }
}

class AumentarVolumeCommand implements Comando {
    private final Televisao televisao;

    public AumentarVolumeCommand(Televisao televisao) {
        this.televisao = televisao;
    }

    @Override
    public void executar() {
        televisao.aumentarVolume();
    }
}

class DiminuirVolumeCommand implements Comando {
    private final Televisao televisao;

    public DiminuirVolumeCommand(Televisao televisao) {
        this.televisao = televisao;
    }

    @Override
    public void executar() {
        televisao.diminuirVolume();
    }
}

// Classe Receiver (Televisão)
class Televisao {
    public void ligarLayout() {
        System.out.println("LIGANDO");
    }

    public void desligarLayout() {
        System.out.println("DESLIGANDO");
    }

    public void aumentarVolume() {
        System.out.println("AUMENTANDO O VOLUME");
    }

    public void diminuirVolume() {
        System.out.println("DIMINUINDO O VOLUME");
    }
}

// Classe Invoker (Controle Remoto)
class ControleRemoto {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void pressionarBotao() {
        comando.executar();
    }
}

