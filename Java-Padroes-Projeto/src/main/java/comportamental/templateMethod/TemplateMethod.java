package comportamental.templateMethod;

public class TemplateMethod {
    /*
    PROPOSITO:
        O Template Method é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse, mas deixa
        as subclasses sobrescreverem etapas específicas do algoritmo sem modificar sua estrutura.

    GANHOS:
        - Você pode deixar clientes sobrescrever apenas certas partes de um algoritmo grande,
          tornando-os menos afetados por mudanças que acontece por outras partes do algoritmo.
        - Você pode elevar o código duplicado para uma superclasse.

    PERDAS:
        - Alguns clientes podem ser limitados ao fornecer o esqueleto de um algoritmo.
        - Você pode violar o princípio de substituição de Liskov ao suprimir uma etapa padrão de implementação através da subclasse.
        - Implementações do padrão Template Method tendem a ser mais difíceis de se manter quanto mais etapas eles tiverem.

    SOLUCAO:

    */

    public static void main(String[] args) {
        new MensagemEmail().processar();
    }
}

class MensagemEmail extends Mensagem {
    @Override
    protected void enviar() {
        System.out.println("ETAPA: ENVIO");
    }

    @Override
    protected void formatarEspecial() {
        System.out.println("ETAPA: FORMATACAO ESPECIAL");
    }
}

abstract class Mensagem {
    // METHOD TEMPLATE
    public void processar() {
        validar();
        formatar();
        formatarEspecial();
        enviar();
    }

    protected abstract void enviar();

    private void validar() {
        System.out.println("ETAPA: VALIDACAO");
    }

    private void formatar() {
        System.out.println("ETAPA: FORMATACAO");
    }

    protected void formatarEspecial() {
        /*
            HOOK ->
                metodo contido na classe abstrata, onde opcionalmente sera adicionado um comportamento,
                uma vez previsto no algoritmo de funcionamento do method template
        */
    }
}
