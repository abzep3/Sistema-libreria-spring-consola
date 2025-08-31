package com.Sistema_Libreria.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Libro {
    @Id
    @Column(name="id_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String autor;
    private String isbn;
    private boolean disponible;
}