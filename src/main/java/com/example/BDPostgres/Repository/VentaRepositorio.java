package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta,Integer> {

    @Query("SELECT v FROM Venta v JOIN FETCH v.cliente c JOIN FETCH v.empleado e")
    List<Venta> findAllConClienteYEmpleado();

    @Query("SELECT v FROM Venta v WHERE v.empleado.id_empleado = :id_empleado")
    List<Venta> findVentasByEmpleadoId(@Param("id_empleado") Integer id_empleado);
}
