import java.io.*;
import java.util.ArrayList;

//1.
public class Empleado implements Serializable {
    String nombre;
    int edad;
    float salario;

    public Empleado(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{nombre='" + nombre + "', edad=" + edad + ", salario=" + salario + "}";
    }
}

class ArchivoEmpleado {
    String nomA;
    ArrayList<Empleado> empleados = new ArrayList<>();

    public ArchivoEmpleado(String nomA) {
        this.nomA = nomA;
    }

    // a) Implementa el método guardarEmpleado(Empleado e) para almacenar empleados.
    public void guardarEmpleado(Empleado e) {
        empleados.add(e);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(empleados);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // b) Implementa buscaEmpleado(String n) a traves del nombre, para ver los datos
    // del Empleado n.
    public Empleado buscaEmpleado(String nombre) {
        for (Empleado e : empleados) {
            if (e.nombre.equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    // c) Implementa mayorSalario(float sueldo), que devuelva al primer empleado con
    // sueldo mayor al ingresado.
    public Empleado mayorSalario(float sueldo) {
        for (Empleado e : empleados) {
            if (e.salario > sueldo) {
                return e;
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.dat");

        Empleado e1 = new Empleado("Juan", 30, 3000);
        Empleado e2 = new Empleado("Maria", 28, 3500);
        archivo.guardarEmpleado(e1);
        archivo.guardarEmpleado(e2);

        System.out.println("Buscando empleado 'Maria': " + archivo.buscaEmpleado("Maria"));
        System.out.println("Empleado con salario mayor a 3200: " + archivo.mayorSalario(3200));
    }
}