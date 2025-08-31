package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Libro;

import java.util.List;

public interface ILibroServicio {
    public List<Libro> listarLibros();
    public Libro buscarLibroPorId(Integer idLibro); // este se tiene que modificar, es un ejemplo
    public Libro buscarLibroPorIsbn(String isbn); //este tambien se tiene que modificar
    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
}
