import java.io.*;
import java.util.*;

public class Medicamento {
    private String nombre;
    private String tipo;

    public Medicamento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nombre + " | Tipo: " + tipo;
    }
}

class Farmacia {
    private int numeroSucursal;
    private String direccion;
    private List<Medicamento> medicamentos;

    public Farmacia(int numeroSucursal, String direccion) {
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
        this.medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
        return "Sucursal: " + numeroSucursal + " | Dirección: " + direccion;
    }
}

class ArchFarmacia {
    private List<Farmacia> farmacias;

    public ArchFarmacia() {
        this.farmacias = new ArrayList<>();
    }

    public void agregarFarmacia(Farmacia farmacia) {
        farmacias.add(farmacia);
    }

    public void guardarEnArchivo(String nombreArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(farmacias);
        }
    }

    public void leerDesdeArchivo(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                farmacias = new ArrayList<>();
                for (Object item : (List<?>) obj) {
                    if (item instanceof Farmacia) {
                        farmacias.add((Farmacia) item);
                    }
                }
            }
        }
    }

    public void mostrarMedicamentosParaLaTos(int numeroSucursal) {
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getNumeroSucursal() == numeroSucursal) {
                System.out.println("Medicamentos para la tos en la Sucursal " + numeroSucursal + ":");
                for (Medicamento medicamento : farmacia.getMedicamentos()) {
                    if (medicamento.getTipo().equalsIgnoreCase("Tos")) {
                        System.out.println(medicamento);
                    }
                }
            }
        }
    }

    public void mostrarFarmaciasConGolpex() {
        for (Farmacia farmacia : farmacias) {
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                if (medicamento.getNombre().equalsIgnoreCase("Golpex")) {
                    System.out.println(
                            "Sucursal " + farmacia.getNumeroSucursal() + " | Dirección: " + farmacia.getDireccion());
                }
            }
        }
    }
}

class Main {
    // a) Crear, leer y mostrar un Archivo de Farmacias
    public static void main(String[] args) {
        ArchFarmacia archivoFarmacia = new ArchFarmacia();

        Farmacia f1 = new Farmacia(1, "Av. Principal #123");
        f1.agregarMedicamento(new Medicamento("Golpex", "Tos"));
        f1.agregarMedicamento(new Medicamento("Paracetamol", "Fiebre"));

        Farmacia f2 = new Farmacia(2, "Calle Secundaria #456");
        f2.agregarMedicamento(new Medicamento("Golpex", "Tos"));
        f2.agregarMedicamento(new Medicamento("Ibuprofeno", "Dolor"));

        archivoFarmacia.agregarFarmacia(f1);
        archivoFarmacia.agregarFarmacia(f2);

        // b) Mostrar los medicamentos para la tos, de la Sucursal numero X
        archivoFarmacia.mostrarMedicamentosParaLaTos(1);

        // c) Mostrar el número de sucursal y su dirección que tienen el medicamento
        // “Golpex”
        archivoFarmacia.mostrarFarmaciasConGolpex();
    }
}