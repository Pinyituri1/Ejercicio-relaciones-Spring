package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.Empleado;
import com.example.BDPostgres.Repository.EmpleadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepositorio empleadoRepositorio;

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    public void eliminarEmpleado(Integer id_empleado) {
        empleadoRepositorio.deleteById(id_empleado);
    }

    public Empleado actualizarEmpleado(Integer id_empleado, Empleado empleadoActualizado) {
        Optional<Empleado> empleadoExistente = empleadoRepositorio.findById(id_empleado);
        if (empleadoExistente.isPresent()) {
            Empleado empleado = empleadoExistente.get();
            empleado.setNombre(empleadoActualizado.getNombre());
            empleado.setCargo(empleadoActualizado.getCargo());
            empleado.setTelefono(empleadoActualizado.getTelefono());
            return empleadoRepositorio.save(empleado);
        } else {
            return null;
        }
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepositorio.findAll();
    }

    public Optional<Empleado> buscarEmpleadoPorId(Integer id_empleado) {
        return empleadoRepositorio.findById(id_empleado);
    }
}
