package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.DetalleVenta;
import com.example.BDPostgres.Repository.DetalleVentaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {

    private final DetalleVentaRepositorio detalleVentaRepositorio;

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalle) {
        return detalleVentaRepositorio.save(detalle);
    }

    public void eliminarDetalleVenta(Integer id_detalle) {
        detalleVentaRepositorio.deleteById(id_detalle);
    }

    public DetalleVenta actualizarDetalleVenta(Integer id_detalle, DetalleVenta detalleActualizado) {
        Optional<DetalleVenta> detalleExistente = detalleVentaRepositorio.findById(id_detalle);
        if (detalleExistente.isPresent()) {
            DetalleVenta detalle = detalleExistente.get();
            detalle.setCantidad(detalleActualizado.getCantidad());
            detalle.setPrecio_unitario(detalleActualizado.getPrecio_unitario());
            detalle.setProducto(detalleActualizado.getProducto());
            detalle.setVenta(detalleActualizado.getVenta());
            return detalleVentaRepositorio.save(detalle);
        } else {
            return null;
        }
    }

    public List<DetalleVenta> obtenerTodosLosDetalles() {
        return detalleVentaRepositorio.findAll();
    }

    public Optional<DetalleVenta> buscarDetalleVentaPorId(Integer id_detalle) {
        return detalleVentaRepositorio.findById(id_detalle);
    }

    public List<DetalleVenta> obtenerDetallesConProductoYProveedor() {
        return detalleVentaRepositorio.findAllConProductoYProveedor();
    }
}
