package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Libro;
import com.Sistema_Libreria.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio implements ILibroServicio{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLibros() {
        List<Libro> libros = libroRepositorio.findAll();
        return libros;
    }

    @Override
    public Libro buscarLibroPorId(Integer idLibro) {  /// por aca me quede, esta pendiente
        Libro libro = libroRepositorio.findById(idLibro).orElse(null);
        return libro;
    }

//    @Override
//    public Libro buscarLibroPorIsbn(String isbn) {
//        Libro libro = libroRepositorio.findById(isbn).orElse(null);
//        return libro;
//    }


    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
