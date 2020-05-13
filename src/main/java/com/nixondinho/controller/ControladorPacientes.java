package com.nixondinho.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.nixondinho.model.Entidad;
import com.nixondinho.model.Paciente;
import com.nixondinho.services.*;

@Controller
@RequestMapping("/pacientes")
public class ControladorPacientes extends ControladorGeneral implements ControladorInicial {

	@Autowired
	PacienteService pacienteService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping("/listar")
	public String listar(Model model, Pageable pageable) {

		// Cargar los registros de pacientes para que sean leidos por la pagina
		// correspondiente.
		model.addAttribute("pacientes", pacienteService.obtenerPorPaginacion(pageable));

		return "pacientes/listaPacientes";

	}

	@RequestMapping("/eliminarRegistro/{details}")
	public String eliminarRegistro(@RequestParam("campoClave") String campoClave, Model model, Pageable pageable) {

		pacienteService.borrar(campoClave);

		return listar(model, pageable);

	}

	@GetMapping("/cargarRegistro/{details}")
	public String cargarRegistro(@RequestParam("campoClave") String campoClave, Model modelo) throws Exception {

		// Cargar un registro en la pagina correspondiente para luego actualizarlo
		modelo.addAttribute("pacienteActualizar", pacienteService.obtenerPorId(campoClave));

		return "pacientes/actualizarPaciente";
	}

	@PostMapping("/actualizarRegistro/{details}")
	public String actualizarRegistro(@Valid @ModelAttribute("pacienteActualizar") Paciente pacienteActualizar,
			BindingResult resultadoValidacion, Model model, Pageable pageable) throws Exception {

		if (resultadoValidacion.hasErrors()) {

			return "pacientes/actualizarPaciente";

		}

		else {

			pacienteService.crear(pacienteActualizar);

			 listar(model, pageable);
			return "pacientes/listaPacientes";
		}

	}

	@PostMapping("/insertarRegistro/{details}")
	public String insertarRegistro(@Valid @ModelAttribute("pacienteActualizar") Paciente pacienteActualizar,
			BindingResult resultadoValidacion, Model model, Pageable pageable) throws Exception {

		if (resultadoValidacion.hasErrors()) {

			return "pacientes/insertarPaciente";

		}

		else {

			pacienteService.crear(pacienteActualizar);

			return listar(model, pageable);
		}

	}

	@PostMapping("/cargarFormulario")
	public String cargarFormulario(HttpServletRequest request, Model model,
			@ModelAttribute("pacienteActualizar") Paciente pacienteActualizar, Pageable pageable) throws Exception {

		// Cargar el formulario para la insercion de registros
		// listar(model, pageable);
		return "pacientes/insertarPaciente";

	}

}
