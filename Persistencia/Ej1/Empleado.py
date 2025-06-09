import pickle

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __repr__(self):
        return f"Empleado(nombre='{self.nombre}', edad={self.edad}, salario={self.salario})"

class ArchivoEmpleado:
    def __init__(self, nomA):
        self.nomA = nomA
        self.empleados = []
#a) Implementa el método guardarEmpleado(Empleado e) para almacenar empleados.
    def guardarEmpleado(self, e):
        self.empleados.append(e)
        with open(self.nomA, 'wb') as file:
            pickle.dump(self.empleados, file)
    def cargarEmpleados(self):
        try:
            with open(self.nomA, 'rb') as file:
                self.empleados = pickle.load(file)
        except (FileNotFoundError, EOFError):
            self.empleados = []
#b) Implementa buscaEmpleado(String n) a traves del nombre, para ver los datos del Empleado n.

    def buscaEmpleado(self, nombre):
        for e in self.empleados:
            if e.nombre == nombre:
                return e
        return None
#c) Implementa mayorSalario(float sueldo), que devuelva al primer empleado con sueldo mayor al ingresado.
    def mayorSalario(self, sueldo):
        for e in self.empleados:
            if e.salario > sueldo:
                return e
        return None

# Ejemplo de uso
archivo = ArchivoEmpleado("empleados.pkl")
archivo.cargarEmpleados()

empleado1 = Empleado("Juan", 30, 3000)
empleado2 = Empleado("Maria", 28, 3500)

archivo.guardarEmpleado(empleado1)
archivo.guardarEmpleado(empleado2)
archivo.cargarEmpleados()  # Recargar datos después de guardarlos

print("Buscando empleado 'Maria':", archivo.buscaEmpleado("Maria"))
print("Empleado con salario mayor a 3200:", archivo.mayorSalario(3200))