package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Libro;
import com.Sistema_Libreria.modelo.Prestamo;

import java.util.List;

public interface IPrestamoServicio {
    public void guardarPrestamo(Prestamo prestamo);

    public List<Prestamo> listarPrestamos();

    public void devolverPrestamo(Integer idPrestamo);
}
