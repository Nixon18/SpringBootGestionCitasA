package com.nixondinho.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.nixondinho.model.Cita;
import com.nixondinho.model.Entidad;
import com.nixondinho.services.*;

@Controller
@RequestMapping("/citas")
public class ControladorCitas extends ControladorGeneral implements ControladorInicial {

	@Autowired
	MedicoService medicoService;

	@Autowired
	PacienteService pacienteService;

	@Autowired
	CitaService citaService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping("/listar")
	public String listar(Model modelo, Pageable pageable) {
		
		// Devolver una lista de citas para ser leida por  la pagina
		modelo.addAttribute("citas", citaService.obtenerPorPaginacion(pageable));

		return "citas/listaCitas";

	}

	@PostMapping("/insertarRegistro/{details}")
	public String insertarRegistro(@Valid @ModelAttribute("citaInsertar") Cita citaInsertar,
			BindingResult resultadoValidacion, Model model, Pageable pageable) throws Exception {

		// Llamar al metodo para que valide los datos y devuelva la pagina correspondiente
		return validadorRegistros.validarRegistro(citaInsertar, resultadoValidacion, "citas/insertarCita", model,
				pageable);

	}

	@RequestMapping("/cargarFormulario")
	public String cargarFormulario(@ModelAttribute("citaInsertar") Cita citaInsertar, Model modelo, Pageable pageable)
			throws Exception {

		listar(modelo, pageable);

		return "citas/insertarCita";

	}



}
