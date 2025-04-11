package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Producto;
import com.example.BDPostgres.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id_producto) {
        Optional<Producto> producto = productoService.buscarProductoPorId(id_producto);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id_producto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id_producto, @RequestBody Producto productoActualizado) {
        Producto producto = productoService.actualizarProducto(id_producto, productoActualizado);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id_producto) {
        productoService.eliminarProducto(id_producto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/proveedor/{id_proveedor}")
    public List<Producto> listarProductosPorProveedor(@PathVariable Integer id_proveedor) {
        return productoService.obtenerProductosPorProveedor(id_proveedor);
    }
}
