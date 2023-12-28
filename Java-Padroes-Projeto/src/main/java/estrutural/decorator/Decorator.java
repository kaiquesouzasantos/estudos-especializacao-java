package estrutural.decorator;

import lombok.Data;

public class Decorator {
    /*
    PROPOSITO:
        O Decorator é um padrão de projeto estrutural que permite que você acople novos comportamentos
        para objetos ao colocá-los dentro de invólucros de objetos que contém os comportamentos, sem usar heranca.

    GANHOS:
        - Você pode estender o comportamento de um objeto sem fazer um nova subclasse.
        - Você pode adicionar ou remover responsabilidades de um objeto no momento da execução.
        - Você pode combinar diversos comportamentos ao envolver o objeto com múltiplos decoradores.
        - Princípio de responsabilidade única.
        - Você pode dividir uma classe monolítica que implementa muitas possíveis variantes de um comportamento em diversas classes menores.

    PERDAS:
        - É difícil remover um invólucro de uma pilha de invólucros.
        - É difícil implementar um decorador de tal maneira que seu comportamento não dependa da ordem do pilha de decoradores.
        - A configuração inicial do código de camadas pode ficar bastante feia.

    SOLUCAO:
        - Usando decoradores, você pode agrupar objetos inúmeras vezes,
          pois os objetos de destino e os decoradores seguem a mesma interface.
          O objeto resultante terá um comportamento de empilhamento de todos os wrappers.
        - Basicamante, teremos uma Matriosca, onde temos o objeto inicial e envolvemos com inumeras camadas,
          onde uma cada e dependente da camada anterior, dado o acresciomo de funcionalidades
    */

    public static void main(String[] args) {
        System.out.println(
                new EnderecadorCaixaAlta().formataEndereco(
                        new EnderecadorSimples().formataEndereco(
                               new Endereco(
                                       "Rua José Francisco Brandão",
                                       "Cidade Tiradentes",
                                       "São Paulo",
                                       "SP",
                                       "08470-790"
                               )
                        )
                ).getEnderecoFormatado()
        );
    }
}

class EnderecadorCaixaAlta implements Enderecador {
    @Override
    public Endereco formataEndereco(Endereco endereco) {
        endereco.setEnderecoFormatado(
                new EnderecadorSimples().formataEndereco(endereco)
                        .getEnderecoFormatado().toUpperCase()
        );

        return endereco;
    }
}

class EnderecadorSimples implements Enderecador {
    @Override
    public Endereco formataEndereco(Endereco endereco) {
        endereco.setEnderecoFormatado(new StringBuilder()
                .append(endereco.getLogradouro()).append("\n").append(endereco.getBairro())
                .append("\n").append(endereco.getCidade()).append("/").append(endereco.getUf())
                .append("\n").append(endereco.getUf())
                .toString());

        return endereco;
    }
}

@Data
class Endereco {
    private final String logradouro, bairro, cidade, uf, cep;
    private String enderecoFormatado;

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

interface Enderecador {
    Endereco formataEndereco(Endereco endereco);
}

