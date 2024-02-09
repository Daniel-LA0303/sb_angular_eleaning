package com.example.e.learnig.app.service;

import com.example.e.learnig.app.entities.Usuario;
import com.example.e.learnig.app.entities.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario save(Usuario usuario, Set<UsuarioRol> roles) throws Exception;

    public Usuario getUser(String username);

    public void deleteUser(Long id);



}
