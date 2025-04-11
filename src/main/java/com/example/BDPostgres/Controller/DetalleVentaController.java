package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.DetalleVenta;
import com.example.BDPostgres.Service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DetalleVenta")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> listarDetallesVenta() {
        return detalleVentaService.obtenerTodosLosDetalles();
    }

    @PostMapping
    public DetalleVenta crearDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @GetMapping("/{id_detalle}")
    public ResponseEntity<DetalleVenta> obtenerDetalleVenta(@PathVariable Integer id_detalle) {
        Optional<DetalleVenta> detalleVenta = detalleVentaService.buscarDetalleVentaPorId(id_detalle);
        return detalleVenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id_detalle}")
    public ResponseEntity<DetalleVenta> actualizarDetalleVenta(@PathVariable Integer id_detalle, @RequestBody DetalleVenta detalleActualizado) {
        DetalleVenta detalleVenta = detalleVentaService.actualizarDetalleVenta(id_detalle, detalleActualizado);
        return detalleVenta != null ? ResponseEntity.ok(detalleVenta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_detalle}")
    public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable Integer id_detalle) {
        detalleVentaService.eliminarDetalleVenta(id_detalle);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/con-producto-proveedor")
    public List<DetalleVenta> listarDetalleConProductoYProveedor() {
        return detalleVentaService.obtenerDetallesConProductoYProveedor();
    }
}
