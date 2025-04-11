package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.Venta;
import com.example.BDPostgres.Repository.VentaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepositorio ventaRepositorio;

    public Venta guardarVenta(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    public void eliminarVenta(Integer id_venta) {
        ventaRepositorio.deleteById(id_venta);
    }

    public Venta actualizarVenta(Integer id_venta, Venta ventaActualizada) {

        if (ventaRepositorio.existsById(id_venta)) {
            //Venta venta = ventaExistente.get();
            //venta.setFecha(ventaActualizada.getFecha());
            //venta.setCliente(ventaActualizada.getCliente());
            //venta.setEmpleado(ventaActualizada.getEmpleado());
            return ventaRepositorio.save(ventaActualizada);
        } else {
            return null;
        }
    }

    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepositorio.findAll();
    }

    public Optional<Venta> buscarVentaPorId(Integer id_venta) {
        return ventaRepositorio.findById(id_venta);
    }

    public List<Venta> obtenerVentasConClienteYEmpleado() {
        return ventaRepositorio.findAllConClienteYEmpleado();
    }

    public List<Venta> obtenerVentasPorEmpleado(Integer id_empleado) {
        return ventaRepositorio.findVentasByEmpleadoId(id_empleado);
    }
}
