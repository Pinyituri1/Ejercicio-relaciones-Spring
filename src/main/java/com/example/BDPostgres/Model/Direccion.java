package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@NonNull
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;

    @OneToOne(mappedBy = "direccion")
    private Estudiante estudiante;

}

