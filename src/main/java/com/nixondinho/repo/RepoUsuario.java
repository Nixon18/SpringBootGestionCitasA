package com.nixondinho.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nixondinho.model.Usuario;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Integer>, PagingAndSortingRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);

}
