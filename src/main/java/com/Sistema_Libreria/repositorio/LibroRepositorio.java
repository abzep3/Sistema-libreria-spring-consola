package com.Sistema_Libreria.repositorio;

import com.Sistema_Libreria.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {

}
