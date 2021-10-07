package com.regiBoot.controller;

import com.regiBoot.model.Usuario;
import com.regiBoot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<String> salvarUsario(@RequestBody Usuario usuario){
        boolean result = usuarioService.saveUser(usuario);
        if(result)
            return ResponseEntity.ok("Usuário Criado Com Sucesso");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> listarUsuarios()
    {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.getUserByID(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        boolean result = usuarioService.deleteUserById(id);
        if(result)
            return ResponseEntity.ok("Usuário Deletado Com Sucesso!!!");
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
