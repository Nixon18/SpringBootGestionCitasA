package com.nixondinho.model;

import javax.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuarios")
@XmlRootElement
public class Usuario {

	
	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Clave")
	private String clave;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
