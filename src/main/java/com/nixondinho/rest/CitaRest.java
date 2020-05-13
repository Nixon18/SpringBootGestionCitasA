package com.nixondinho.rest;

import org.springframework.http.MediaType;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.nixondinho.model.Cita;
import com.nixondinho.services.CitaService;
import com.nixondinho.services.ValidandoDatos;

@RestController
@RequestMapping(path = "/citas")
public class CitaRest {

	@Autowired
	CitaService citaService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping(value = "/{id}")
	public Cita cargarProducto(@PathVariable("id") Integer id) {

		return citaService.obtenerPorId(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public List<Cita> listar(Pageable pageable) {

		return citaService.obtenerPorPaginacion(pageable);
	}

	@PostMapping
	public String insertar(@RequestBody @Valid Cita cita) throws Exception {

		// Validar lo datos para realizar el proceso de insercion
		return validadorRegistros.validarRegistro(cita);
	}

}
