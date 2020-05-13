package com.nixondinho.model;

import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * @author Hp DV6000
 *
 */
@Entity
@Table(name = "pacientes")

public class Paciente  implements Entidad{

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = "rango valido: 1 a 40 caracteres")

	@Column(name = "Nombre_Completo")
	private String nombre;

	@NotNull(message = "campo requerido")

	@Column(name = "Fecha_Nacimiento")
	private String fechaNacimiento;

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

	@Column(name = "Eps")
	private String eps;

	@NotNull(message = "campo requerido")
	@Size(min = 10, max = 100, message = "rango valido: 10 a 100 caracteres")

	@Column(name = "Historia_Clinica")
	private String historiaClinica;

	public Paciente() {
	}

	public Paciente(String nombre, String fechaNacimiento, String identificacion, String tipoIdentificacion, String eps,
			String historiaClinica) {

		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.eps = eps;
		this.historiaClinica = historiaClinica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(String historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

}
