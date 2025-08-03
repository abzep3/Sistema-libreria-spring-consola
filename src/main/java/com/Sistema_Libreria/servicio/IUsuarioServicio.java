package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();

    public Usuario buscarUsuarioPorId(Integer id_usuario);

    public void guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);
}
