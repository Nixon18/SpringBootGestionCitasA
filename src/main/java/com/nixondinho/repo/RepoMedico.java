package com.nixondinho.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.nixondinho.model.Medico;

@Repository
public interface RepoMedico extends JpaRepository<Medico, String>, PagingAndSortingRepository<Medico, String> {

	// Este metodo lista los registros con paginacion
	public Page<Medico> findAll(Pageable pageable);
	

}
