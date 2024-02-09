package com.example.e.learnig.app.service.Impl;

import com.example.e.learnig.app.entities.Usuario;
import com.example.e.learnig.app.entities.UsuarioRol;
import com.example.e.learnig.app.repository.RolRepository;
import com.example.e.learnig.app.repository.UsuarioRepository;
import com.example.e.learnig.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Usuario save(Usuario usuario, Set<UsuarioRol> roles) throws Exception{
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioLocal != null) {
            System.out.println("El usuario ya existe");

            throw new Exception("El usuario ya existe");
        } else {
            for (UsuarioRol ur : roles) {
                rolRepository.save(ur.getRol());
            }
            usuario.getUsuarioRol().addAll(roles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario getUser(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}
