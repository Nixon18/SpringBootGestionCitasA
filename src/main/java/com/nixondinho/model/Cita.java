package com.nixondinho.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "citas")
@XmlRootElement
public class Cita  implements Entidad {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	@Column(name = "Registro")
	private Integer registro;

	@NotNull(message = "campo requerido")

	@Column(name = "Paciente")
	private String paciente;

	@NotNull(message = "campo requerido")

	@Column(name = "Medico")
	private String medico;

	@NotNull(message = "campo requerido")

	@Column(name = "Horario_Cita")
	private String horarioCita;

	public Cita() {

	}

	public Cita(Integer registro, String paciente, String medico, String horarioCita) {
		
		this.registro = registro;
		this.paciente = paciente;
		this.medico = medico;
		this.horarioCita = horarioCita;
		
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getHorarioCita() {
		return horarioCita;
	}

	public void setHorarioCita(String horarioCita) {
		this.horarioCita = horarioCita;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}
	
	

}
