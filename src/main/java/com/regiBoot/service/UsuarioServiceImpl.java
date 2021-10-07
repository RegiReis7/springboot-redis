package com.regiBoot.service;

import com.regiBoot.model.Usuario;
import com.regiBoot.repository.UsuarioDAO;
import com.regiBoot.repository.UsuarioDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean saveUser(Usuario usuario) {
        return usuarioDAO.saveUser(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsarios();
    }

    @Override
    public Usuario getUserByID(Long id) {
        return usuarioDAO.getUserById(id);
    }
}
