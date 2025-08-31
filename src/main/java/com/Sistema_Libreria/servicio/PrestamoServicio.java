package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Libro;
import com.Sistema_Libreria.modelo.Prestamo;
import com.Sistema_Libreria.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServicio implements IPrestamoServicio{

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Override
    public void guardarPrestamo(Prestamo prestamo) {
        prestamoRepositorio.save(prestamo);
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        List<Prestamo> prestamos = prestamoRepositorio.findAll();
        return prestamos;
    }

    @Override
    public void devolverPrestamo(Integer idPrestamo) {
        Prestamo prestamo = prestamoRepositorio.findById(idPrestamo)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));
        if(prestamo.isDevuelto()){
            throw new IllegalStateException("El prestamo ya fue devuelto");
        }

        //estado del prestamo
        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(LocalDate.now());
        //estado del libro
        Libro libro = prestamo.getLibro();
        libro.setDisponible(true);

        prestamoRepositorio.save(prestamo);
    }
}
