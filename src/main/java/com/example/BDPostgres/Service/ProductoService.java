package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.Producto;
import com.example.BDPostgres.Repository.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepositorio productoRepository;

    // GUARDAR
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // ELIMINAR
    public void eliminarProducto(Integer id_producto) {
        productoRepository.deleteById(id_producto);
    }

    // ACTUALIZAR
    public Producto actualizarProducto(Integer id_producto, Producto productoActualizado) {
        Optional<Producto> productoExistente = productoRepository.findById(id_producto);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            producto.setProveedor(productoActualizado.getProveedor());
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    // BUSCAR TODOS
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Producto> buscarProductoPorId(Integer id_producto) {
        return productoRepository.findById(id_producto);
    }

    public List<Producto> obtenerProductosPorProveedor(Integer id_proveedor) {
        return productoRepository.findByProveedor(id_proveedor);
    }
}
