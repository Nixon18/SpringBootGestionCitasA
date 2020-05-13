 package com.nixondinho.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "medicos")

public class Medico  implements Entidad{

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = " rango valido: 1 a 40 caracteres")

	@Column(name = "Nombre_Completo")
	private String nombre;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = "rango valido: 1 a 40 caracteres")

	@Id
	@Column(name = "Identificacion")
	private String identificacion;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 20, message = "rango valido: 1 a 20 caracteres")

	@Column(name = "Tipo_Identificacion")
	private String tipoIdentificacion;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 20, message = "rango valido: 1 a 20 caracteres")

	@Column(name = "Numero_Tarjeta_Profesional")
	private String numeroTarjetaProfesional;

	@NotNull(message = "campo requerido")
	@Min(value = 1, message = "ingrese experiencias mayore a 1 año")

	@Column(name = "Tiempo_Experiencia")
	private Float tiempoExperiencia;

	@NotNull(message = "campo requerido")

	@Column(name = "Especialidad")
	private String especialidad;

	@NotNull(message = "campo requerido")

	@Column(name = "Hora_Inicio_Atencion")
	private String inicioAtencion;

	@NotNull(message = "campo requerido")

	@Column(name = "Hora_Fin_Atencion")
	private String finAtencion;

	public Medico() {
	}

	public Medico(String nombre, String identificacion, String tipoIdentificacion, String numeroTarjetaProfesional,
			Float tiempoExperiencia, String especialidad, String inicioAtencion, String finAtencion) {

		this.nombre = nombre;
		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroTarjetaProfesional = numeroTarjetaProfesional;
		this.tiempoExperiencia = tiempoExperiencia;
		this.especialidad = especialidad;
		this.inicioAtencion = inicioAtencion;
		this.finAtencion = finAtencion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroTarjetaProfesional() {
		return numeroTarjetaProfesional;
	}

	public void setNumeroTarjetaProfesional(String numeroTarjetaProfesional) {
		this.numeroTarjetaProfesional = numeroTarjetaProfesional;
	}

	public Float getTiempoExperiencia() {
		return tiempoExperiencia;
	}

	public void setTiempoExperiencia(Float tiempoExperiencia) {
		this.tiempoExperiencia = tiempoExperiencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getInicioAtencion() {
		return inicioAtencion;
	}

	public void setInicioAtencion(String inicioAtencion) {
		this.inicioAtencion = inicioAtencion;
	}

	public String getFinAtencion() {
		return finAtencion;
	}

	public void setFinAtencion(String finAtencion) {
		this.finAtencion = finAtencion;
	}

}
