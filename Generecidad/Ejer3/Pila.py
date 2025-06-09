# 5: Crea una clase genérica Pila<T>
class Pila:
    def __init__(self):
        self.elementos = []
#a) Implementa un método para apilar
    def apilar(self, elemento):
        self.elementos.append(elemento)
#b) Implementa un método para des apilar
    def desapilar(self):
        if self.elementos:
            return self.elementos.pop()
        print("La pila está vacía")
        return None

    def mostrar_pila(self):
        print("Contenido de la pila:", self.elementos)

#c) Prueba la pila con diferentes tipos de datos
#d) Muestra los datos de la pila
pila_enteros = Pila()
pila_enteros.apilar(10)
pila_enteros.apilar(20)
pila_enteros.mostrar_pila()
print("Elemento desapilado:", pila_enteros.desapilar())
pila_enteros.mostrar_pila()

pila_strings = Pila()
pila_strings.apilar("Python")
pila_strings.apilar("Java")
pila_strings.mostrar_pila()
print("Elemento desapilado:", pila_strings.desapilar())
pila_strings.mostrar_pila()