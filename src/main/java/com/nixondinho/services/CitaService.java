package com.nixondinho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nixondinho.model.Cita;
import com.nixondinho.repo.RepoCita;

@Service
public class CitaService implements ServiceGeneral {

	@Autowired
	private RepoCita repoCita;

	public void crear(Cita cita) {

		repoCita.save(cita);

	}

	public List<Cita> obtener() {

		// Retornar todos los registros de esta entidad
		return repoCita.findAll();

	}

	public List<Cita> obtenerPorPaginacion(Pageable pageable) {

		// Retornar todos los registros de esta entidad con paginacion
		return repoCita.findAll(pageable).getContent();

	}

	public Cita obtenerPorId(Integer id) {

		try {
			return repoCita.findById(id).get();
		} catch (Exception e) {

			return null;
		}

	}

	public Cita obtenerPorHorarioCitaYPaciente(String horarioCita, String paciente) {

		try {
			return repoCita.findByHorarioCitaAndPaciente(horarioCita, paciente).get();
		} catch (Exception e) {

			return null;
		}
	}

	public Cita obtenerPorHorarioCitaYMedico(String horarioCita, String medico) {

		try {
			return repoCita.findByHorarioCitaAndMedico(horarioCita, medico).get();
		} catch (Exception e) {

			return null;
		}
	}

}
