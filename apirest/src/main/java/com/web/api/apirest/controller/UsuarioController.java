package com.web.api.apirest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.api.apirest.model.Usuario;
import com.web.api.apirest.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping("/usuarios")
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return usuarioRepository.finByUsername(username);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id) {
        usuarioRepository.remove(id);
    }

    @PostMapping("/usuarios")
    public void postUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}