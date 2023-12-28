package criacional.builder;

public class Builder {
    /*
    PROPOSITO:
        O Builder é um padrão de projeto criacional que permite a você construir objetos complexos passo a passo.
        O padrão permite que você produza diferentes tipos e representações de um objeto usando o mesmo código de construção.

    GANHOS:
        - Você pode construir objetos passo a passo, adiar as etapas de construção ou rodar etapas recursivamente.
        - Você pode reutilizar o mesmo código de construção quando construindo várias representações de produtos.
        - Princípio de responsabilidade única. Você pode isolar um código de construção complexo da lógica de negócio do produto.

    PERDAS:
        - A complexidade geral do código aumenta uma vez que o padrão exige criar múltiplas classes novas.

    SOLUCAO:
        O padrao permite que uma classe manipule(builder) um modelo representacional, instanciando-a e construindo-a de forma interna.
        Uma vez instanciada uma classe builder, na sua construcao ela instancia o objeto representacional.
        Ela deve ser capaz de manipular todos os atributos presentes no objeto, assim tambem,
        todos os metodos acessores devem retornar a propria instancia do builder(com o uso do 'this').
        E necessario haver um metodo capaz de retornar a instacia do objeto representacional, utilizado para concretizar a concepcao do mesmo
    */

    public static void main(String[] args) {
        System.out.println(
                new PessoaBuilder().nome("kaique").idade(17).builder()
        );
    }
}

class PessoaBuilder {
    private final Pessoa pessoa;

    public PessoaBuilder() {
        this.pessoa = new Pessoa();
    }

    public Pessoa builder() {
        return pessoa;
    }

    public PessoaBuilder nome(String nome) {
        this.pessoa.setNome(nome);
        return this;
    }

    public PessoaBuilder idade(int idade) {
        this.pessoa.setIdade(idade);
        return this;
    }
}

class Pessoa {
    private String nome;
    private int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
