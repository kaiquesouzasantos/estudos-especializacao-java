package criacional.singleton;

public class Singleton {
    /*
    PROPOSITO:
        O Singleton é um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma instância,
        enquanto provê um ponto de acesso global para essa instância.

    GANHOS:
        - Fornece um ponto de acesso global para aquela instância.
        - Garantir que uma classe tenha apenas uma única instância.

    PERDAS:
        - Viola o princípio de responsabilidade única. O padrão resolve dois problemas de uma só vez.
        - O padrão Singleton pode mascarar um design ruim, por exemplo, quando os componentes do programa sabem muito sobre cada um.
        - O padrão requer tratamento especial em um ambiente multithreaded para que múltiplas threads não possam criar um objeto singleton várias vezes.
        - Pode ser difícil realizar testes unitários do código cliente do Singleton porque muitos frameworks de teste dependem de herança quando produzem objetos simulados.
          Já que o construtor da classe singleton é privado e sobrescrever métodos estáticos é impossível na maioria das linguagem,
          você terá que pensar em uma maneira criativa de simular o singleton. Ou apenas não escreva os testes. Ou não use o padrão Singleton.

    SOLUCAO:
        - Fazer o construtor padrão privado, para prevenir que outros objetos usem o operador new com a classe singleton.
        - Criar um método estático de criação que age como um construtor.
          Esse método chama o construtor privado por debaixo dos panos para criar um objeto e o salva em um campo estático.
          Todas as chamadas seguintes para esse método retornam o objeto em cache.
    */

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            System.out.println(Objeto.getInstance());
        }
    }
}

class Objeto {
    private static Objeto objeto;

    private Objeto() { }

    public static Objeto getInstance() {
        if(objeto == null)
            objeto = new Objeto();

        return objeto;
    }
}