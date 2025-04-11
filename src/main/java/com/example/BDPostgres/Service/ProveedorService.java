package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.Proveedor;
import com.example.BDPostgres.Repository.ProveedorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepositorio proveedorRepositorio;

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    public void eliminarProveedor(Integer id_proveedor) {
        proveedorRepositorio.deleteById(id_proveedor);
    }

    public Proveedor actualizarProveedor(Integer id_proveedor, Proveedor proveedorActualizado) {
        Optional<Proveedor> proveedorExistente = proveedorRepositorio.findById(id_proveedor);
        if (proveedorExistente.isPresent()) {
            Proveedor proveedor = proveedorExistente.get();
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setCorreo(proveedorActualizado.getCorreo());
            proveedor.setTelefono(proveedorActualizado.getTelefono());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            return proveedorRepositorio.save(proveedor);
        } else {
            return null;
        }
    }

    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepositorio.findAll();
    }

    public Optional<Proveedor> buscarProveedorPorId(Integer id_proveedor) {
        return proveedorRepositorio.findById(id_proveedor);
    }
}
