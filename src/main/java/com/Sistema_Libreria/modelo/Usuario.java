package com.Sistema_Libreria.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carnet;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String estado;

}
