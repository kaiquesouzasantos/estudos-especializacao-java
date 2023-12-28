package comportamental.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    /*
    PROPOSITO:
        O Observer é um padrão de projeto comportamental que permite que você defina um mecanismo de assinatura para
        notificar múltiplos objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

    GANHOS:
        - Princípio aberto/fechado. Você pode introduzir novas classes assinantes sem ter que mudar o código da publicadora
          (e vice versa se existe uma interface publicadora).
        - Você pode estabelecer relações entre objetos durante a execução.

    PERDAS:
        -  Assinantes são notificados em ordem aleatória.

    SOLUCAO:
        - O Observer é um padrão de projeto comportamental que permite que um objeto notifique outros objetos sobre alterações em seu estado.
        - O padrão Observer fornece uma maneira de assinar e cancelar a assinatura desses eventos para qualquer objeto
          que implemente uma interface de assinante.
        - O padrão de projeto Observer é utilizado quando um objeto, chamado de "sujeito" (subject), mantém uma lista de objetos dependentes,
          chamados de "observadores" (observers), que são notificados automaticamente de qualquer mudança de estado.
    */

    public static void main(String[] args) {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();

        DisplayTemperatura display1 = new DisplayTemperatura();
        DisplayTemperatura display2 = new DisplayTemperatura();

        estacao.registrarObservador(display1);
        estacao.registrarObservador(display2);

        estacao.setTemperatura(25.0f);
        estacao.setTemperatura(28.5f);
        estacao.removerObservador(display1);
        estacao.setTemperatura(30.0f);
    }
}

// ConcreteObserver (Observador Concreto)
class DisplayTemperatura implements Observador {
    private float temperatura;

    @Override
    public void atualizar(float temperatura) {
        this.temperatura = temperatura;
        mostrarTemperatura();
    }

    public void mostrarTemperatura() {
        System.out.println("Temperatura atual: " + temperatura + " graus Celsius");
    }
}

// ConcreteSubject (Sujeito Concreto)
class EstacaoMeteorologica implements Sujeito {
    private final List<Observador> observadores;
    private float temperatura;

    public EstacaoMeteorologica() {
        this.observadores = new ArrayList<>();
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(
                observador -> observador.atualizar(temperatura)
        );
    }
}

// Observer (Observador)
interface Observador {
    void atualizar(float temperatura);
}

// Subject (Sujeito)
interface Sujeito {
    void registrarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores();
}
