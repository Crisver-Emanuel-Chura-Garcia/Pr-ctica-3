import java.util.ArrayList;
import java.util.List;

//3. Crea una clase genérica Catalogo<T> que almacene productos o libros.
public class Catalogo<T> {
    private List<T> elementos;

    public Catalogo() {
        this.elementos = new ArrayList<>();
    }

    // a) Agrega métodos para agregar y buscar elemento
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public boolean buscar(T elemento) {
        return elementos.contains(elemento);
    }

    public void mostrarCatalogo() {
        System.out.println("Contenido del catálogo:");
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        // b) Prueba el catálogo con libros
        Catalogo<String> libros = new Catalogo<>();
        libros.agregar("1984");
        libros.agregar("El Principito");
        System.out.println("¿Está '1984' en el catálogo?: " + libros.buscar("1984"));
        libros.mostrarCatalogo();
        // c) Prueba el catálogo con productos
        Catalogo<String> productos = new Catalogo<>();
        productos.agregar("Laptop");
        productos.agregar("Teléfono");
        System.out.println("¿Está 'Laptop' en el catálogo?: " + productos.buscar("Laptop"));
        productos.mostrarCatalogo();
    }
}