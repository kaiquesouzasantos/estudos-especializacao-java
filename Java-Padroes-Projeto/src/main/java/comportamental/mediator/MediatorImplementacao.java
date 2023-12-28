package comportamental.mediator;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

class Mediator {
    /*
    PROPOSITO:
        O MediatorImplementacao é um padrão de projeto comportamental que permite que você reduza as dependências caóticas entre objetos.
        O padrão restringe comunicações diretas entre objetos e os força a colaborar apenas através do objeto mediador.

    GANHOS:
        - Princípio de responsabilidade única. Você pode extrair as comunicações entre vários componentes para um único lugar,
          tornando as de mais fácil entendimento e manutenção.
        - Princípio aberto/fechado. Você pode introduzir novos mediadores sem ter que mudar os próprios componentes.
        - Você pode reduzir o acoplamento entre os vários componentes de um programa.
        - Você pode reutilizar componentes individuais mais facilmente.

    PERDAS:
        -  Com o tempo um mediador pode evoluir para um Objeto Deus.

    SOLUCAO:
        - O MediatorImplementacao é um padrão de projeto comportamental que reduz o acoplamento entre os componentes de um programa,
          fazendo-os se comunicar indiretamente, por meio de um objeto mediador especial.
        - O MediatorImplementacao facilita a modificação, a extensão e a reutilização de componentes individuais porque eles não são mais
          dependentes de dezenas de outras classes.
        - “Definir um objeto que encapsula a forma como um conjunto de objetos interage.
          O MediatorImplementacao promove o acoplamento fraco ao evitar que os objetos se refiram uns aos outros explicitamente e permite variar
          suas interações independentemente.”
        - Gamma et al. (2007) sugere o uso do padrão mediator quando:
            - objetos se comunicam de forma especifica e complexa
            - reutilização de um objeto se torna difícil, devido a quantidade de objetos no qual ele se comunica
            - quando temos comportamentos distribuídos e esse comportamento deveria ser customizável.
    */

    public static void main(String[] args) {
        // N usuarios cantem a referencia para 1 implementacao do mediador, que por sua vez, implementa uma interface com a funcionalidade mor garantida
        MediatorImplementacao mediator = new MediatorImplementacao();

        Usuario usuario1 = new Usuario("Charles", mediator);
        Usuario usuario2 = new Usuario("Cristiano", mediator);
        Usuario usuario3 = new Usuario("Camila", mediator);

        mediator.adicionarUsuario(usuario1);
        mediator.adicionarUsuario(usuario2);
        mediator.adicionarUsuario(usuario3);

        usuario1.enviarMensagem("Olá, pessoal!");
        usuario2.enviarMensagem("Oi, meu nobre!");
        usuario3.enviarMensagem("Oi, gente!");
    }
}

class MediatorImplementacao implements ChatMediator {
    private final List<Usuario> usuarios;

    public MediatorImplementacao() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        for (Usuario usuario : usuarios) {
            // Garante que o remetente não recebe a própria mensagem
            if (usuario != remetente) {
                usuario.receberMensagem(mensagem);
            }
        }
    }
}

@AllArgsConstructor
class Usuario {
    private final String nome;
    private final ChatMediator chatMediator;

    public void enviarMensagem(String mensagem) {
        System.out.println("[" + nome + "] ENVIOU: " + mensagem);
        chatMediator.enviarMensagem(mensagem, this);
    }

    public void receberMensagem(String mensagem) {
        System.out.println("[" + nome + "] RECEBEU: " + mensagem);
    }
}

interface ChatMediator {
    void enviarMensagem(String mensagem, Usuario usuario);
}