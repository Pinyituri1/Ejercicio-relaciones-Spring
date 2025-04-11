package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Integer> {

    @Query("SELECT dv FROM DetalleVenta dv JOIN FETCH dv.producto p JOIN FETCH p.proveedor")
    List<DetalleVenta> findAllConProductoYProveedor();

}
