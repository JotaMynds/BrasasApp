# 🔥 BrasasApp

**BrasasApp** es una aplicación de gestión de restaurante que ofrece dos interfaces principales: una para clientes y otra para administradores. Permite gestionar empleados, productos, pedidos, y realizar pagos a través de diferentes métodos. Está desarrollada en Java con múltiples paquetes organizados por funcionalidad.

---

## 🧑‍🍳 Funcionalidades principales

### 👨‍💼 Administrador

- 🔐 Iniciar sesión y registrarse
- 👥 Gestionar empleados
- 🍽️ Gestionar carta de productos
- 📋 Ver registros de logs (empleados y productos)

### 🧑‍🍽 Cliente

- 📜 Ver la carta del restaurante
- 🛒 Realizar pedidos
- 💳 Pagar con diferentes métodos:
  - Bizum
  - Paypal
  - Tarjeta
  - Efectivo

---

## 📁 Estructura del proyecto

La aplicación está organizada en los siguientes **12 paquetes**:

### `Administrador`

- `RegAdminSQL`: Pantalla de login y registro del administrador.
- `StaffMenu`: Menú principal para administradores.

### `Administrador.Comandas`

- Pantalla de gestión de productos.
- Gestión de comandas.
- Registro de logs.
- Gestión de empleados.

### `Administrador.Empleados`

- `Eliminar_Pedidos`: Eliminar pedidos desde la interfaz.
- `Gestor_Pedidos`: Ver comandas activas y marcarlas como listas.

### `Administrador.Logs`

- `ListaLogsEmplSQL`: Ver logs de empleados.
- `ListaLogsProdSQL`: Ver logs de productos.
- `MenuLogs`: Interfaz gráfica para visualizar logs.

### `Administrador.Productos`

- `Insertar_ProductoSQL`: Añadir nuevos productos.
- `ListaProductosSQL`: Listar productos disponibles.
- `ModificarProductoSQL`: Modificar detalles de productos existentes.

### `Cliente`

- `CartaSQL`: Mostrar la carta y permitir realizar pedidos.
- `InicioSesionSQL`: Introducir nombre y mesa del cliente.
- Métodos de pago:
  - `PagoConBizum`
  - `PagoConPaypal`
  - `PagoConTargeta`
  - `PagoEnEfectivo`
- `PagoSQL`: Pantalla para seleccionar el método de pago.

### `Conexion`

- Métodos para conectar con la base de datos MySQL.

### `Imagenes`

- Recursos gráficos utilizados en la aplicación.

### `Inicial`

- `Inicio`: Pantalla principal para elegir el modo (Cliente o Administrador).

### `PantallasDeCarga`

- Código para mostrar pantallas de carga durante operaciones.

### `Plantillas`

- Clases plantilla con getters, setters, constructores y `toString`:
  - `Empleado`
  - `Pedidos`
  - `Producto`
- Helpers con métodos auxiliares:
  - `EmpleadoService`
  - `PedidosHelper`
  - `ProductoHelper`

### `Tests`

- Pruebas unitarias (JUnit) para:
  - Empleado
  - Pedidos
  - Producto

