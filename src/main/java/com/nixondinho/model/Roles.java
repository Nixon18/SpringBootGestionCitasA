package com.nixondinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@Column(name = "registro")
	private int registro;

	@Column(name = "rol")
	private String rol;

	public Roles() {

	}

	public Roles(int registro, String rol) {

		this.registro = registro;
		this.rol = rol;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
