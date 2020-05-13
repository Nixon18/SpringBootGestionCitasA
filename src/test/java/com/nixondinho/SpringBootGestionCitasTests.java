package com.nixondinho;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nixondinho.model.Usuario;
import com.nixondinho.repo.RepoUsuario;

@SpringBootTest
class SpringBootGestionCitasTests {

	@Autowired
	private RepoUsuario repoUsuario;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
		Usuario usuario = new Usuario();

		usuario.setId(2);
		usuario.setNombre("messi");
		usuario.setClave(encoder.encode("123456"));

		Usuario usuarioRetorno = repoUsuario.save(usuario);
		
		assertTrue(usuario.getNombre().equalsIgnoreCase(usuarioRetorno.getNombre()));

	}

}
