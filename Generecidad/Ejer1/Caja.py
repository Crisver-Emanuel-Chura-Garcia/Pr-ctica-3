from typing import TypeVar, Generic, List
# 1. Crea una clase genérica Caja<T> para guardar algún tipo de objeto
T = TypeVar("T")

class Caja(Generic[T]):
    def __init__(self):
        self.contenido: List[T] = [] 

# a) Agrega métodos guardar() y obtener()
    def agregar(self, newElem: T) -> None:
        self.contenido.append(newElem)

    def obtener(self) -> List[T]:
        return self.contenido
# b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
CajaVideojuegos = Caja[str]()
CajaMatematica = Caja[int]()

CajaVideojuegos.agregar("The Legend of Zelda")
CajaVideojuegos.agregar("Pokémon")
CajaMatematica.agregar(2005)
CajaMatematica.agregar(1999)
# c) Muestra el contenido de las cajas
print(CajaVideojuegos.obtener())  
print(CajaMatematica.obtener())   
