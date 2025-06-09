import java.util.ArrayList;
import java.util.List;

//1. Crea una clase genérica Caja<T> para guardar algún tipo de objeto
public class Caja<T> {
    private List<T> contenido;

    public Caja() {
        this.contenido = new ArrayList<>();
    }
    // a) Agrega métodos guardar() y obtener()

    public void agregar(T newElem) {
        contenido.add(newElem);
    }

    public List<T> obtener() {
        return contenido;
    }

    public static void main(String[] args) {
        // b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
        Caja<String> CajaShrodinguer = new Caja<>();
        Caja<Float> CajaFloat = new Caja<>();
        CajaShrodinguer.agregar("Gato");
        CajaShrodinguer.agregar("Frasco de Veneno");
        CajaFloat.agregar(3.1415f);
        CajaFloat.agregar(2.7182f);
        // c) Muestra el contenido de las cajas
        System.out.println(CajaShrodinguer.obtener());
        System.out.println(CajaFloat.obtener());
    }
}