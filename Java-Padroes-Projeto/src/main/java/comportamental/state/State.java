package comportamental.state;

import java.util.List;

public class State {
    /*
    PROPOSITO:
        O State é um padrão de projeto comportamental que permite que um objeto altere seu comportamento
        quando seu estado interno muda. Parece como se o objeto mudasse de classe.

    GANHOS:
        - Princípio de responsabilidade única. Organiza o código relacionado a estados particulares em classes separadas.
        - Princípio aberto/fechado. Introduz novos estados sem mudar classes de estado ou contexto existentes.
        - Simplifica o código de contexto ao eliminar condicionais de máquinas de estado pesadas.

    PERDAS:
        - Aplicar o padrão pode ser um exagero se a máquina de estado só tem alguns estados ou raramente muda eles.

    SOLUCAO:
        O padrão extrai comportamentos relacionados ao estado em classes separadas de estado e força o
        objeto original a delegar o trabalho para uma instância dessas classes, em vez de agir por conta própria.
    */

    public static void main(String[] args) {
        List.of(
                new Mario(), new MarioInvencivel(), new SuperMario(), new FireMario()
        ).forEach(State::procedimentoTeste);
    }

    private static void procedimentoTeste(Estado personagem) {
        System.out.println("TIPO INICIAL: " + personagem.getTipo());

        personagem = personagem.pegarCogumelo();
        personagem = personagem.pegarFlorDeFogo();
        personagem = personagem.pegarCogumelo();
        personagem = personagem.colidirComInimigo();

        System.out.println("TIPO FINAL: " + personagem.getTipo() + "\n");
    }
}

class Mario implements Estado {
    @Override
    public Estado pegarCogumelo() {
        System.out.println("PEGOU O COGUMELO, TORNOU-SE: SUPER MARIO");
        return new SuperMario();
    }

    @Override
    public Estado pegarEstrela() {
        System.out.println("PEGOU UMA ESTRELA, TORNOU-SE: MARIO INVENCIVEL");
        return new MarioInvencivel();
    }

    @Override
    public Estado pegarFlorDeFogo() {
        System.out.println("PEGOU UMA FLOR, TORNOU-SE: MARIO ATIRA FOGO");
        return null;
    }

    @Override
    public Estado colidirComInimigo() {
        System.out.println("COLIDIU COM O INIMIGO, TORNOU-SE: MORTO");
        return new MarioMorto();
    }

    @Override
    public String getTipo() {
        return "BAIXINHO";
    }
}

class MarioInvencivel implements Estado {
    @Override
    public Estado pegarCogumelo() {
        System.out.println("PEGOU O COGUMELO: CONTINUA INVENCIVEL");
        return this;
    }

    @Override
    public Estado pegarEstrela() {
        System.out.println("PEGOU UMA ESTRELA, TORNOU-SE: MARIO INVENCIVEL");
        return this;
    }

    @Override
    public Estado pegarFlorDeFogo() {
        System.out.println("PEGOU UMA FLOR, TORNOU-SE: MARIO ATIRA FOGO E AINDA ESTA INVENCIVEL");
        return this;
    }

    @Override
    public Estado colidirComInimigo() {
        System.out.println("COLIDIU COM O INIMIGO: O INIMIGO MORREU");
        return new MarioMorto();
    }

    @Override
    public String getTipo() {
        return "INVENCIVEL";
    }
}

class SuperMario implements Estado {
    @Override
    public Estado pegarCogumelo() {
        System.out.println("PEGOU O COGUMELO: MAIS 1000 PONTOS");
        return this;
    }

    @Override
    public Estado pegarEstrela() {
        System.out.println("PEGOU UMA ESTRELA, TORNOU-SE: MARIO INVENCIVEL");
        return new MarioInvencivel();
    }

    @Override
    public Estado pegarFlorDeFogo() {
        System.out.println("PEGOU UMA FLOR, TORNOU-SE: MARIO ATIRA FOGO ");
        return new FireMario();
    }

    @Override
    public Estado colidirComInimigo() {
        System.out.println("COLIDIU COM O INIMIGO, TORNOU-SE: MARIO BAIXINHO");
        return new Mario();
    }

    @Override
    public String getTipo() {
        return "SUPER";
    }
}

class FireMario implements Estado {
    @Override
    public Estado pegarCogumelo() {
        System.out.println("PEGOU O COGUMELO: MAIS 1000 PONTOS");
        return this;
    }

    @Override
    public Estado pegarEstrela() {
        System.out.println("PEGOU UMA ESTRELA, TORNOU-SE: MARIO INVENCIVEL");
        return new MarioInvencivel();
    }

    @Override
    public Estado pegarFlorDeFogo() {
        System.out.println("PEGOU UMA FLOR: CONTINUA COM PODERES DE FOGO");
        return this;
    }

    @Override
    public Estado colidirComInimigo() {
        System.out.println("COLIDIU COM O INIMIGO, TORNOU-SE: SUPER MARIO");
        return new SuperMario();
    }

    @Override
    public String getTipo() {
        return "FIRE";
    }
}

class MarioMorto implements Estado {
    @Override
    public Estado pegarCogumelo() {
        return this;
    }

    @Override
    public Estado pegarEstrela() {
        return this;
    }

    @Override
    public Estado pegarFlorDeFogo() {
        return this;
    }

    @Override
    public Estado colidirComInimigo() {
        return null;
    }

    @Override
    public String getTipo() {
        return "MORTO";
    }
}

interface Estado {
    Estado pegarCogumelo();
    Estado pegarEstrela();
    Estado pegarFlorDeFogo();
    Estado colidirComInimigo();
    String getTipo();
}
