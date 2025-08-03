package com.Sistema_Libreria.servicio;

import com.Sistema_Libreria.modelo.Usuario;
import com.Sistema_Libreria.repositorio.LibroRepositorio;
import com.Sistema_Libreria.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id_usuario) {
        Usuario usuario = usuarioRepositorio.findById(id_usuario).orElse(null);
        return usuario;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
}
