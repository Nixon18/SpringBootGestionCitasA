package com.nixondinho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nixondinho.model.Entidad;
import com.nixondinho.model.Paciente;
import com.nixondinho.repo.RepoPaciente;

@Service
public class PacienteService implements ServiceGeneral {

	@Autowired
	private RepoPaciente repoPaciente;

	public PacienteService() {
	}

	public void crear(Paciente paciente) {

		repoPaciente.save(paciente);

	}

	public void actualizar(Paciente paciente) {

		repoPaciente.save(paciente);

	}

	public void borrar(String id) {

		repoPaciente.deleteById(id);

	}

	public List<Paciente> obtener() {

		// Listar todos los registros de esta entidad
		return repoPaciente.findAll();

	}

	public Paciente obtenerPorId(String id) {
		try {
			return repoPaciente.findById(id).get();
		} catch (Exception e) {

			return null;
		}

	}

	public List<Paciente> obtenerPorPaginacion(Pageable pageable) {

		// Listar todos los registros con paginacion
		return repoPaciente.findAll(pageable).getContent();

	}

}
