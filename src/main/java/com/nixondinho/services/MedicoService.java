package com.nixondinho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nixondinho.model.Entidad;
import com.nixondinho.model.Medico;
import com.nixondinho.repo.RepoMedico;

@Service
public class MedicoService implements ServiceGeneral{

	@Autowired

	private RepoMedico repoMedico;

	public void crear(Medico medico) {

		repoMedico.save(medico);

	}

	public void actualizar(Medico medico) {

		repoMedico.save(medico);

	}

	public void borrar(String codigo) {

		repoMedico.deleteById(codigo);

	}

	public List<Medico> obtener() {

		// Retornar todos los registros de esta entidad
		return repoMedico.findAll();

	}

	public Medico obtenerPorId(String id) {

		try {
			return repoMedico.findById(id).get();
		} catch (Exception e) {

			return null;
		}

	}

	public List<Medico> obtenerPorPaginacion(Pageable pageable) {

		// Retornar todos los registros de esta entidad con paginacion
		return repoMedico.findAll(pageable).getContent();

	}

}
