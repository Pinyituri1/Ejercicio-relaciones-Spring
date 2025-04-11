package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Proveedor;
import com.example.BDPostgres.Service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedorService.obtenerTodosLosProveedores();
    }

    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    @GetMapping("/{id_proveedor}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Integer id_proveedor) {
        Optional<Proveedor> proveedor = proveedorService.buscarProveedorPorId(id_proveedor);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id_proveedor}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id_proveedor, @RequestBody Proveedor proveedorActualizado) {
        Proveedor proveedor = proveedorService.actualizarProveedor(id_proveedor, proveedorActualizado);
        return proveedor != null ? ResponseEntity.ok(proveedor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_proveedor}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id_proveedor) {
        proveedorService.eliminarProveedor(id_proveedor);
        return ResponseEntity.noContent().build();
    }
}
