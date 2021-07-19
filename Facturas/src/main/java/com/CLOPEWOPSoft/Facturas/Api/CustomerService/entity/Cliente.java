package com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("nombres")
	@Column(name = "Nombres")
	@NotNull(message = "Se requiere un nombre")
	private String nombres;
	
	@JsonProperty("apellidos")
	@Column(name = "Apellidos")
	@NotNull(message = "Se requieren los apellidos")
	private String apellidos;
	
	@Id
	@JsonProperty("rfc")
	@Column(name = "RFC")
	@NotNull(message = "Se requiere el RFC")
	private String rfc;
	
	@JsonProperty("correo")
	@Column(name = "correo")
	@NotNull(message = "Se requiere el correo")
	private String correo;
	
	@JsonProperty("id_region")
	@Valid
	@ManyToOne
	@JoinColumn(name = "ID_Region")
	private Region idRegion;
}
