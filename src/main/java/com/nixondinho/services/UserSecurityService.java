package com.nixondinho.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nixondinho.model.Roles;
import com.nixondinho.model.Usuario;
import com.nixondinho.repo.RepoRoles;
import com.nixondinho.repo.RepoUsuario;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private RepoUsuario repoUsuario;

	@Autowired
	private RepoRoles repoRoles;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = repoUsuario.findByNombre(username);

		List<Roles> rolesBBDD = repoRoles.findAll();

		List<GrantedAuthority> roles = new ArrayList<>();

		for (Roles rol : rolesBBDD) {

			roles.add(new SimpleGrantedAuthority(rol.getRol()));
		}

		UserDetails usuarioDetails = new User(usuario.getNombre(), usuario.getClave(), roles);

		return usuarioDetails;
	}

}
