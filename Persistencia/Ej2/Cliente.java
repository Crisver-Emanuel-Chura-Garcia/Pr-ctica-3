import java.util.ArrayList;
import java.util.List;

//3.
//a) Implementar el diagrama de clases.
public class Cliente {
    int id;
    String nombre;
    int telefono;

    public Cliente(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', telefono=" + telefono + "}";
    }
}

class ArchivoCliente {
    String nomA;
    List<Cliente> clientes;

    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
        this.clientes = new ArrayList<>();
    }

    public void guardaCliente(Cliente c) {
        clientes.add(c);
    }

    // b) Implementa buscarCliente(int c) a través del id.
    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.id == id) {
                return c;
            }
        }
        return null;
    }

    // c) Implementa buscarCelularCliente(int c), que devuelva los datos del cliente
    // junto al número de celular.
    public Cliente buscarCelularCliente(int id) {
        return buscarCliente(id);
    }

    public void mostrarEjemplo() {
        Cliente c1 = new Cliente(1, "Emanuel", 7654321);
        Cliente c2 = new Cliente(2, "Luis", 9876543);
        guardaCliente(c1);
        guardaCliente(c2);

        System.out.println(buscarCliente(1));
        System.out.println(buscarCelularCliente(2));
    }
}

class Main {
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.txt");
        archivo.mostrarEjemplo();
    }
}