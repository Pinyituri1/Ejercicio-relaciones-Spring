package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {
    @Query("SELECT p FROM Producto p WHERE p.proveedor.id_proveedor = :id_proveedor")
    List<Producto> findByProveedor(@Param("id_proveedor") Integer id_proveedor);
}
