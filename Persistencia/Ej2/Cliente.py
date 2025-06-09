class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"Cliente(id={self.id}, nombre={self.nombre}, telefono={self.telefono})"


class ArchivoCliente:
    def __init__(self, nomA):
        self.nomA = nomA
        self.clientes = []

    def guarda_cliente(self, cliente):
        self.clientes.append(cliente)

    def buscar_cliente(self, id):
        for cliente in self.clientes:
            if cliente.id == id:
                return cliente
        return None

    def buscar_celular_cliente(self, id):
        return self.buscar_cliente(id)

    def mostrar_ejemplo(self):
        c1 = Cliente(1, "Emanuel", 7654321)
        c2 = Cliente(2, "Luis", 9876543)
        self.guarda_cliente(c1)
        self.guarda_cliente(c2)

        print(self.buscar_cliente(1))
        print(self.buscar_celular_cliente(2))


if __name__ == "__main__":
    archivo = ArchivoCliente("clientes.txt")
    archivo.mostrar_ejemplo()