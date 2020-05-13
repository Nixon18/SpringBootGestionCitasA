package com.nixondinho.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/inicio")
public class ControladorGeneral {

	@RequestMapping
	public final String inicio() {

		return "paginaInicial";

	}
	
	@InitBinder
	public void miBinder(WebDataBinder binder) {

		// Metodo que recorta los espacios en blanco de la informacion que llega por el request
		
		StringTrimmerEditor metodoTrim = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, metodoTrim);
	}

}
