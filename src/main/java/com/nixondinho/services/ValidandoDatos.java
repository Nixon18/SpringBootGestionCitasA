package com.nixondinho.services;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nixondinho.controller.ControladorCitas;
import com.nixondinho.controller.ControladorMedicos;
import com.nixondinho.controller.ControladorPacientes;
import com.nixondinho.model.*;

@Service
public class ValidandoDatos {

	@Autowired
	MedicoService medicoService; 

	@Autowired
	PacienteService pacienteService;

	@Autowired
	CitaService citaService;

	@Autowired
	private ControladorMedicos controladorMedicos;

	@Autowired
	private ControladorPacientes controladorPacientes;

	@Autowired
	private ControladorCitas controladorCitas;

	private int horaInicial, horaFinal, horarioCita;
	private Cita disponibilidadPaciente, disponibilidadMedico;
	private boolean rangoCita;


	public String validarRegistro(@Valid @ModelAttribute("citaInsertar") Cita citaInsertar,
			BindingResult resultadoValidacion, String pagina, Model modelo, Pageable pageable) throws Exception {

		String mensajeValidacion = "Valide el horario del medico asignado";

		if (resultadoValidacion.hasErrors()) {

			return pagina;

		}

		else {

			if (pacienteService.obtenerPorId(citaInsertar.getPaciente()) == null) {
				modelo.addAttribute("validarPaciente", "el paciente asignado no existe");
				return pagina;

			} else if (medicoService.obtenerPorId(citaInsertar.getMedico()) == null) {
				modelo.addAttribute("validarMedico", "el medico asignado no existe");
				return pagina;
			}

			else {

				ObtenerDatosCita(citaInsertar);

				if (rangoCita) {

					modelo.addAttribute("validarRango", mensajeValidacion);
					return pagina;

				} else {

					if ((disponibilidadPaciente != null) || (disponibilidadMedico != null)) {

						modelo.addAttribute("disponibilidadCita",
								"la hora solicitada ya esta agendada con este medico");
						System.out.println("hora ya asignada");
						return pagina;

					} else {
						System.out.println("hora no asignada");
						citaService.crear(citaInsertar);

						controladorCitas.listar(modelo, pageable);

						return "citas/listaCitas";

					}

				}

			}

		}

	}

	public String validarRegistro(Cita citaInsertar) throws Exception {

		String mensajeValidacion = "Valide el horario del medico asignado";

		if (pacienteService.obtenerPorId(citaInsertar.getPaciente()) == null) {

			return "el paciente asignado no existe";

		} else if (medicoService.obtenerPorId(citaInsertar.getMedico()) == null) {

			return "el medico asignado no existe";
		}

		else {

			boolean obtenerDatosCita = ObtenerDatosCita(citaInsertar);

			if (!obtenerDatosCita) {

				return "ingrese un tipo de dato numerico.";

			} else {

				if (rangoCita) {

					return mensajeValidacion;

				} else {

					if ((disponibilidadPaciente != null) || (disponibilidadMedico != null)) {

						return "la hora solicitada ya esta agendada con ese medico o paciente";

					} else {

						citaService.crear(citaInsertar);

						return "datos insertados correctamente.";

					}

				}

			}

		}

	}

	public boolean ObtenerDatosCita(Cita citaInsertar) {

		horaInicial = Integer.parseInt(medicoService.obtenerPorId(citaInsertar.getMedico()).getInicioAtencion());
		horaFinal = Integer.parseInt(medicoService.obtenerPorId(citaInsertar.getMedico()).getFinAtencion());

		disponibilidadPaciente = citaService.obtenerPorHorarioCitaYPaciente(citaInsertar.getHorarioCita(),
				citaInsertar.getPaciente());
		disponibilidadMedico = citaService.obtenerPorHorarioCitaYMedico(citaInsertar.getHorarioCita(),
				citaInsertar.getMedico());
		try {
			horarioCita = Integer.parseInt(citaInsertar.getHorarioCita());
			rangoCita = (horarioCita < horaInicial) || (horarioCita > horaFinal);

			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
