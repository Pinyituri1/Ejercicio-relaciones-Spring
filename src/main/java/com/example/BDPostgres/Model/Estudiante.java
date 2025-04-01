package com.example.BDPostgres.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nombre;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)  // Relación con Curso
    private Curso curso;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones;

    @OneToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion; // Relación uno a uno con Direccion
}
