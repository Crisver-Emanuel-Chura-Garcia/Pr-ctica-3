import java.util.Stack;

//5: Crea una clase genérica Pila<T>
public class Pila<T> {
    private Stack<T> elementos;

    public Pila() {
        this.elementos = new Stack<>();
    }

    // a) Implementa un método para apilar
    public void apilar(T elemento) {
        elementos.push(elemento);
    }

    // b) Implementa un método para des apilar
    public T desapilar() {
        if (!elementos.isEmpty()) {
            return elementos.pop();
        }
        System.out.println("La pila está vacía");
        return null;
    }

    public void mostrarPila() {
        System.out.println("Contenido de la pila: " + elementos);
    }

    public static void main(String[] args) {
        // c) Prueba la pila con diferentes tipos de datos
        // d) Muestra los datos de la pila
        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.apilar(10);
        pilaEnteros.apilar(20);
        pilaEnteros.mostrarPila();
        System.out.println("Elemento desapilado: " + pilaEnteros.desapilar());
        pilaEnteros.mostrarPila();

        Pila<String> pilaStrings = new Pila<>();
        pilaStrings.apilar("Python");
        pilaStrings.apilar("Java");
        pilaStrings.mostrarPila();
        System.out.println("Elemento desapilado: " + pilaStrings.desapilar());
        pilaStrings.mostrarPila();
    }
}