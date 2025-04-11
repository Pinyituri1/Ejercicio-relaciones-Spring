package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Empleado;
import com.example.BDPostgres.Service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping("/{id_empleado}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Integer id_empleado) {
        Optional<Empleado> empleado = empleadoService.buscarEmpleadoPorId(id_empleado);
        return empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id_empleado}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id_empleado, @RequestBody Empleado empleadoActualizado) {
        Empleado empleado = empleadoService.actualizarEmpleado(id_empleado, empleadoActualizado);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_empleado}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id_empleado) {
        empleadoService.eliminarEmpleado(id_empleado);
        return ResponseEntity.noContent().build();
    }
}
