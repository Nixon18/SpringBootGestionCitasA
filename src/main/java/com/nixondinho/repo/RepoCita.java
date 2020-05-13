package com.nixondinho.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.nixondinho.model.Cita;

@Repository
public interface RepoCita extends JpaRepository<Cita, Integer>, PagingAndSortingRepository<Cita, Integer> {

	// Este metodo lista los registros con paginacion
	public Page<Cita> findAll(Pageable pageable);

	public abstract Optional<Cita> findByHorarioCitaAndPaciente(String horarioCita, String paciente);

	public abstract Optional<Cita> findByHorarioCitaAndMedico(String horarioCita, String medico);

}
