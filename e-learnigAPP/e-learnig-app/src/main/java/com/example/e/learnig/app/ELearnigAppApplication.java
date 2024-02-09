package com.example.e.learnig.app;

import com.example.e.learnig.app.entities.Rol;
import com.example.e.learnig.app.entities.Usuario;
import com.example.e.learnig.app.entities.UsuarioRol;
import com.example.e.learnig.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ELearnigAppApplication
	/*implements CommandLineRunner*/
{

	/*@Autowired
	private UsuarioService usuarioService;*/

	public static void main(String[] args) {
		SpringApplication.run(ELearnigAppApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();

		usuario.setUsername("admin");
		usuario.setPassword("admin");
		usuario.setName("admin");
		usuario.setLastname("admin");
		usuario.setEmail("email@email.com");
		usuario.setPhone("1234567890");
		usuario.setPerfil("foto.jpg");


		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setName("ADMIN");


		Set< UsuarioRol > usuarioRol = new HashSet<>();
		UsuarioRol usuarioRol1 = new UsuarioRol();
		usuarioRol1.setRol(rol);
		usuarioRol1.setUsuario(usuario);
		usuarioRol.add(usuarioRol1);

		Usuario u = usuarioService.save(usuario, usuarioRol);
		System.out.println(u.getUsername());

	}*/
}
