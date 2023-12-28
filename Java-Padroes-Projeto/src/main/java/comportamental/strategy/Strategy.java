package comportamental.strategy;

public class Strategy {
    /*
    PROPOSITO:
        O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em
        classes separadas, e faça os objetos deles intercambiáveis.

    GANHOS:
        - Você pode trocar algoritmos usados dentro de um objeto durante a execução.
        - Você pode isolar os detalhes de implementação de um algoritmo do código que usa ele.
        - Você pode substituir a herança por composição.
        - Princípio aberto/fechado. Você pode introduzir novas estratégias sem mudar o contexto.

    PERDAS:
        - Se você só tem um par de algoritmos e eles raramente mudam, não há motivo real para deixar o programa mais complicado
          com novas classes e interfaces que vêm junto com o padrão.
        - Os Clientes devem estar cientes das diferenças entre as estratégias para serem capazes de selecionar a adequada.
        - Muitas linguagens de programação modernas tem suporte do tipo funcional que permite que você implemente diferentes versões
          de um algoritmo dentro de um conjunto de funções anônimas. Então você poderia usar essas funções exatamente como se estivesse
          usando objetos estratégia, mas sem inchar seu código com classes e interfaces adicionais.

    SOLUCAO:
        - Dado um contexto/classe que contem uma referencia a uma implementacao/interface strategy, por sua vez,
          obriga outras classes que as extendem implementem uma funcionalidade. Sendo que, se alterado o algoritmo,
          o contexto nao e diretamente inflingido.
        - O Strategy é um padrão de projeto comportamental que transforma um conjunto de comportamentos em objetos
          e os torna intercambiáveis dentro do objeto de contexto original.
        - O objeto original, chamado contexto, mantém uma referência a um objeto strategy e o delega a execução do
          comportamento. Para alterar a maneira como o contexto executa seu trabalho, outros objetos podem substituir o
          objeto strategy atualmente vinculado por outro.
    */

    public static void main(String[] args) {
        // para um mesmo objeto, sao aplicados diferentes algoritmos, porem a sua funcionalidade se mantem
        CarrinhoCompras carrinho = new CarrinhoCompras();

        carrinho.setFormatoPagamento(new PagamentoCartaoCredito());
        carrinho.finalizarCompra(100.0);

        carrinho.setFormatoPagamento(new PagamentoBoleto());
        carrinho.finalizarCompra(150.0);

        carrinho.setFormatoPagamento(new PagamentoPayPal());
        carrinho.finalizarCompra(200.0);
    }
}

// Interface Strategy
interface FormatoPagamento {
    void processarPagamento(double valor);
}

// Implementações concretas das estratégias
class PagamentoCartaoCredito implements FormatoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento via cartão de crédito: R$" + valor);
    }
}

class PagamentoBoleto implements FormatoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Emitindo boleto bancário: R$" + valor);
    }
}

class PagamentoPayPal implements FormatoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento via PayPal: R$" + valor);
    }
}

// Contexto que utiliza a estratégia
class CarrinhoCompras {
    private FormatoPagamento formatoPagamento;

    public void setFormatoPagamento(FormatoPagamento formatoPagamento) {
        this.formatoPagamento = formatoPagamento;
    }

    public void finalizarCompra(double valorTotal) {
        formatoPagamento.processarPagamento(valorTotal);
    }
}
