# 🛠 Ejercicio - Relaciones en Spring

Inserciones hechas en Postman:

```json


Proveedores:
[
    { "nombre": "Florería Bogotá", "telefono": "3011111111", "direccion": "Calle 10 #20-30" },
    { "nombre": "Floristería Medellín", "telefono": "3022222222", "direccion": "Carrera 45 #5-10" },
    { "nombre": "Rosas del Valle", "telefono": "3033333333", "direccion": "Av. Central #40-50" },
    { "nombre": "Flores y Más", "telefono": "3044444444", "direccion": "Calle 50 #12-80" },
    { "nombre": "La Casa de las Flores", "telefono": "3055555555", "direccion": "Carrera 7 #15-60" }
]

Productos:
[
    { "nombre": "Rosa roja", "descripcion": "Rosa roja natural", "precio": 3500.00, "stock": 100, "idProveedor": 1 },
    { "nombre": "Lirio blanco", "descripcion": "Lirio blanco perfumado", "precio": 5000.00, "stock": 80, "idProveedor": 2 },
    { "nombre": "Girasol", "descripcion": "Flor de girasol", "precio": 3000.00, "stock": 120, "idProveedor": 3 },
    { "nombre": "Tulipán", "descripcion": "Tulipán rojo", "precio": 4500.00, "stock": 60, "idProveedor": 4 },
    { "nombre": "Orquídea", "descripcion": "Orquídea morada", "precio": 7000.00, "stock": 40, "idProveedor": 5 }
]

Clientes:
[
    { "nombre": "Andrea Martínez", "correo": "andrea@gmail.com", "telefono": "3111111111" },
    { "nombre": "Carlos Torres", "correo": "carlos@gmail.com", "telefono": "3122222222" },
    { "nombre": "Lucía Gómez", "correo": "lucia@gmail.com", "telefono": "3133333333" },
    { "nombre": "Juan Rodríguez", "correo": "juanr@gmail.com", "telefono": "3144444444" },
    { "nombre": "Diana López", "correo": "diana@gmail.com", "telefono": "3155555555" }
]

Empleados:
[
    { "nombre": "Pedro Sánchez", "correo": "pedro@empresa.com", "cargo": "Cajero" },
    { "nombre": "Marta Ruiz", "correo": "marta@empresa.com", "cargo": "Vendedor" },
    { "nombre": "José Pérez", "correo": "jose@empresa.com", "cargo": "Administrador" },
    { "nombre": "Laura Ríos", "correo": "laura@empresa.com", "cargo": "Florista" },
    { "nombre": "Andrés Silva", "correo": "andres@empresa.com", "cargo": "Repartidor" }
]

Ventas:
[
    { "fecha": "2025-04-10", "idEmpleado": 1, "idCliente": 1 },
    { "fecha": "2025-04-10", "idEmpleado": 2, "idCliente": 2 },
    { "fecha": "2025-04-09", "idEmpleado": 3, "idCliente": 3 },
    { "fecha": "2025-04-08", "idEmpleado": 4, "idCliente": 4 },
    { "fecha": "2025-04-07", "idEmpleado": 5, "idCliente": 5 }
]

Detalles de venta:
[
    { "cantidad": 5, "precio_unitario": 3500.00, "idProducto": 1, "idVenta": 1 },
    { "cantidad": 2, "precio_unitario": 5000.00, "idProducto": 2, "idVenta": 2 },
    { "cantidad": 10, "precio_unitario": 3000.00, "idProducto": 3, "idVenta": 3 },
    { "cantidad": 3, "precio_unitario": 4500.00, "idProducto": 4, "idVenta": 4 },
    { "cantidad": 1, "precio_unitario": 7000.00, "idProducto": 5, "idVenta": 5 }
]
# Quiz10_04_2025
# ParcialLinea3_21_04_2025
