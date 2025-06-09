#3. Crea una clase genérica Catalogo<T> que almacene productos o libros.
class Catalogo:
    def __init__(self):
        self.elementos = []
#a) Agrega métodos para agregar y buscar elemento
    def agregar(self, elemento):
        self.elementos.append(elemento)

    def buscar(self, elemento):
        return elemento in self.elementos

    def mostrar_catalogo(self):
        print("Contenido del catálogo:")
        for elemento in self.elementos:
            print(elemento)

#b) Prueba el catálogo con libros
libros = Catalogo()
libros.agregar("1984")
libros.agregar("El Principito")
print("¿Está '1984' en el catálogo?:", libros.buscar("1984"))
libros.mostrar_catalogo()

# c) Prueba el catálogo con productos
productos = Catalogo()
productos.agregar("Laptop")
productos.agregar("Teléfono")
print("¿Está 'Laptop' en el catálogo?:", productos.buscar("Laptop"))
productos.mostrar_catalogo()