package estrutural.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Adapter {
    /*
    PROPOSITO:
        O Adapter é um padrão de projeto estrutural que permite objetos com interfaces incompatíveis colaborarem entre si.

    GANHOS:
        - Princípio de responsabilidade única. Você pode separar a conversão de interface ou de dados da lógica primária do negócio do programa.
        - Princípio aberto/fechado. Você pode introduzir novos tipos de adaptadores no programa sem quebrar o código cliente existente,
          desde que eles trabalhem com os adaptadores através da interface cliente.

    PERDAS:
        -  A complexidade geral do código aumenta porque você precisa introduzir um conjunto de novas interfaces e classes.
           Algumas vezes é mais simples mudar a classe serviço para que ela se adeque com o resto do seu código.

    SOLUCAO:
        O Adapter atua como um wrapper entre dois objetos, semelhante a um mapper.
        Ele captura chamadas para um objeto e as deixa reconhecíveis tanto em formato como interface para este segundo objeto.
    */

    public static void main(String[] args) {
        // basicamente, o padrao institui um cast entre objetos, um tipo de mapper estrutural
        CotacaoAdapter cotacao = new CotacaoAdapter(new Cotacao(1.0));
        System.out.println(cotacao);
    }
}

class CotacaoAdapter extends Cotacao {
    public CotacaoAdapter(Cotacao cotacao) {
        super(cotacao.getValor());
    }

    public double getValorDolar() {
        return super.getValor() / 5.0;
    }

    @Override
    public String toString() {
        return "CotacaoAdapter{" + getValor() + ", " + getValorDolar() + "}";
    }
}

@Data
@AllArgsConstructor
class Cotacao {
    private double valor;
}
