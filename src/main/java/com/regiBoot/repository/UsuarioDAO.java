package com.regiBoot.repository;

import com.regiBoot.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    boolean saveUser(Usuario usuario);

    List<Usuario> listarUsarios();
}
