package comportamental.memento;

public class Memento {
    /*
    PROPOSITO:
       O Memento é um padrão de projeto comportamental que permite que
       você salve e restaure o estado anterior de um objeto sem revelar os detalhes de sua implementação.

    GANHOS:
        -  Você pode produzir retratos do estado de um objeto sem violar seu encapsulamento.
        - Você pode simplificar o código da originadora permitindo que a cuidadora mantenha o histórico do estado da originadora.

    PERDAS:
        - A aplicação pode consumir muita RAM se os clientes criarem mementos com muita frequência.
        - Cuidadoras devem acompanhar o ciclo de vida da originadora para serem capazes de destruir mementos obsoletos.
        - A maioria das linguagens de programação dinâmicas, tais como PHP, Python, e JavaScript, não conseguem garantir
          que o estado dentro do memento permaneça intacto.

    SOLUCAO:
        - O Memento é um padrão de projeto comportamental que permite tirar um “retrato” do estado de um objeto e restaurá-lo no futuro.
        - O Memento não compromete a estrutura interna do objeto com o qual trabalha, nem os dados mantidos dentro dos retratos.
        - O padrão de projeto Memento é utilizado para capturar e externalizar um estado interno de um objeto, permitindo que o objeto seja restaurado para esse estado mais tarde.
    */

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Zelador zelador = new Zelador();

        /*
            no exemplo em questao, dado o objeto EstadoEditor, uma vez inicializado atraves da classe EditorTexto,
            se torna capaz de ser recuperado, quando salvo no Zelador.

            Originator:
                - É a classe que possui o estado interno que queremos salvar e restaurar.
                  Ela cria e armazena os mementos (estados salvos) e também pode restaurar o estado anterior a partir de um memento.
            Memento:
                - É uma classe que armazena o estado interno de um objeto Originator.
                  O memento é inalterável por classes externas ao Originator, garantindo assim a integridade do estado armazenado.
            Caretaker:
                - É a classe que é responsável por manter e gerenciar os mementos criados pelo Originator.
                  O Caretaker não deve manipular ou interpretar o estado armazenado nos mementos, mas apenas salvá-los e restaurá-los conforme necessário.
        */

        editor.escreverTexto("1 - PRIMEIRA LINHA");
        zelador.salvarEstado(editor);
        editor.escreverTexto("2 - SEGUNDA LINHA");
        editor.imprimirTexto();
        zelador.restaurarEstado(editor);
        editor.imprimirTexto();
    }
}

// Memento
class EstadoEditor {
    private final String texto;

    public EstadoEditor(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}

// Originator (Origem)
class EditorTexto {
    private String texto;

    public void escreverTexto(String novoTexto) {
        System.out.println("[ESCREVENDO] TEXTO: " + novoTexto);
        this.texto = novoTexto;
    }

    public EstadoEditor salvarEstado() {
        System.out.println("[SALVANDO] ESTADO DO EDITOR");
        return new EstadoEditor(texto);
    }

    public void restaurarEstado(EstadoEditor estado) {
        System.out.println("[RESTAURANDO] ESTADO DO EDITOR");
        this.texto = estado.getTexto();
    }

    public void imprimirTexto() {
        System.out.println("TEXTO ATUAL: " + texto);
    }
}

// Caretaker (Zelador)
class Zelador {
    private EstadoEditor estadoSalvo;

    public void salvarEstado(EditorTexto editorTexto) {
        estadoSalvo = editorTexto.salvarEstado();
    }

    public void restaurarEstado(EditorTexto editorTexto) {
        editorTexto.restaurarEstado(estadoSalvo);
    }
}

