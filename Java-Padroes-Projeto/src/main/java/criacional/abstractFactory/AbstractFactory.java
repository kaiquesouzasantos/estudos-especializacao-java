package criacional.abstractFactory;

import lombok.Builder;
import lombok.Data;

public class AbstractFactory {
    /*
    PROPOSITO:
        O Abstract Factory é um padrão de projeto criacional que permite que você produza famílias de
        objetos relacionados sem ter que especificar suas classes concretas.

    GANHOS:
        - Você pode ter certeza que os produtos que você obtém de uma fábrica são compatíveis entre si.
        - Você evita um vínculo forte entre produtos concretos e o código cliente.
        - Princípio de responsabilidade única. Você pode extrair o código de criação do produto para um lugar, fazendo o código ser de fácil manutenção.
        - Princípio aberto/fechado. Você pode introduzir novas variantes de produtos sem quebrar o código cliente existente.

    PERDAS:
        - O código pode tornar-se mais complicado do que deveria ser, uma vez que muitas novas interfaces e classes são introduzidas junto com o padrão.

    SOLUCAO:

    */

    public static void main(String[] args) {
        new Venda(new Loja())
                .vender(
                        Produto.builder()
                            .nome("Teclado")
                            .quantidade(2)
                            .valorUnitario(260.0)
                            .build()
        );
    }
}

class Loja implements VendaFactory {
    @Override
    public NFE criarNFE() {
        return new NFESaoPaulo();
    }

    @Override
    public Boleto criarBoleto() {
        return new BoletoBanco();
    }
}

class Venda {
    private final NFE notaFiscal;
    private final Boleto boleto;

    public Venda(VendaFactory factory) {
        this.notaFiscal = factory.criarNFE();
        this.boleto = factory.criarBoleto();
    }

    public void vender(Produto produto) {
        double imposto = notaFiscal.calcularImposto(produto);
        boleto.emitir(produto, imposto);
    }
}

class NFESaoPaulo implements NFE {
    @Override
    public double calcularImposto(Produto produto) {
        return produto.valorUnitario * 0.18;
    }
}

class BoletoBanco implements Boleto{
    @Override
    public void emitir(Produto produto, double imposto) {
        System.out.println(
                produto.toString() + " | IMPOSTO R$: " + imposto
        );
    }
}

interface VendaFactory {
    NFE criarNFE();
    Boleto criarBoleto();
}

interface NFE {
    double calcularImposto(Produto produto);
}

interface Boleto {
    void emitir(Produto produto, double imposto);
}

@Data
@Builder
class Produto {
    private String nome;
    private int quantidade;
    public double valorUnitario;
}