package com.example.BDPostgres.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "id_cliente", nullable = false)
    private int idCliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;
    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Empleado empleado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DetalleVenta> detalleVentas;
}

