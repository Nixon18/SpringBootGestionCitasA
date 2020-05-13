package com.nixondinho.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.nixondinho.model.Entidad;
import com.nixondinho.model.Medico;
import com.nixondinho.services.*;

@Controller
@RequestMapping("/medicos")
public class ControladorMedicos extends ControladorGeneral implements ControladorInicial {

	@Autowired
	MedicoService medicoService;

	@Autowired
	PacienteService pacienteService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping("/listar")
	public String listar(Model modelo, Pageable pageable) {

		// Cargar la lista de metodos para se leida por la pagina correspondiente
		modelo.addAttribute("medicos", medicoService.obtenerPorPaginacion(pageable));

		return "medicos/listaMedicos";

	}

	@RequestMapping("/eliminarRegistro/{details}")
	public String eliminarRegistro(@RequestParam("campoClave") String campoClave, Model modelo, Pageable pageable) {

		medicoService.borrar(campoClave);

		return listar(modelo, pageable);

	}

	@GetMapping("/cargarRegistro/{details}")
	public String cargarRegistro(@RequestParam("campoClave") String campoClave, Model modelo) throws Exception {

		// Cargar un registro por su campo clave
		modelo.addAttribute("medicoActualizar", medicoService.obtenerPorId(campoClave));

		return "medicos/actualizarMedico";
	}

	@PostMapping("/actualizarRegistro/{details}")
	public String actualizaRegistro(@Valid @ModelAttribute("medicoActualizar") Medico medicoActualizar,
			BindingResult resultadoValidacion, Model modelo, Pageable pageable) throws Exception {

		if (resultadoValidacion.hasErrors()) {

			return "medicos/actualizarMedico";

		}

		else {

			medicoService.crear(medicoActualizar);

			return listar(modelo, pageable);
		}

	}

	@PostMapping("/insertarRegistro/{details}")
	public String insertarRegistro(@Valid @ModelAttribute("medicoActualizar") Medico medicoActualizar,
			BindingResult resultadoValidacion, Model modelo, Pageable pageable) throws Exception {

		if (resultadoValidacion.hasErrors()) {

			return "medicos/insertarMedico";

		}

		else {

			medicoService.crear(medicoActualizar);

			return listar(modelo, pageable);
		}

	}

	@RequestMapping("/cargarFormulario")
	public String cargarFormulario(@ModelAttribute("medicoActualizar") Medico medicoActualizar, Model modelo,
			Pageable pageable) throws Exception {

		// Cargar el formulario para la insercion de registros

		// listar(modelo, pageable);

		return "medicos/insertarMedico";

	}

}
