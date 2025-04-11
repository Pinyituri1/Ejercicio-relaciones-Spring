package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Venta;
import com.example.BDPostgres.Service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Venta")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/{id_venta}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Integer id_venta) {
        Optional<Venta> venta = ventaService.buscarVentaPorId(id_venta);
        return venta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id_venta}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id_venta, @RequestBody Venta ventaActualizada) {
        Venta venta = ventaService.actualizarVenta(id_venta, ventaActualizada);
        return venta != null ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_venta}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id_venta) {
        ventaService.eliminarVenta(id_venta);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/con-cliente-empleado")
    public List<Venta> listarVentasConClienteYEmpleado() {
        return ventaService.obtenerVentasConClienteYEmpleado();
    }

    @GetMapping("/empleado/{id_empleado}")
    public List<Venta> listarVentasPorEmpleado(@PathVariable Integer id_empleado) {
        return ventaService.obtenerVentasPorEmpleado(id_empleado);
    }
}
