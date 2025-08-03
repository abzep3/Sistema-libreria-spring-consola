package com.Sistema_Libreria.repositorio;

import com.Sistema_Libreria.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
