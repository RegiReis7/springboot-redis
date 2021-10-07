package com.regiBoot.service;

import com.regiBoot.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean saveUser(Usuario usuario);

    List<Usuario> listarUsuarios();
}
