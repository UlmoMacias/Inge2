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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("nombres")
	@Column(name = "Nombres")
	@NotNull(message = "Se requiere un nombre")
	private String nombres;
	
	@JsonProperty("a_paterno")
	@Column(name = "APaterno")
	@NotNull(message = "Se requiere el apellido paterno")
	private String aPaterno;
	
	@JsonProperty("a_materno")
	@Column(name = "AMaterno")
	@NotNull(message = "Se requiere el apellido materno")
	private String aMaterno;
	
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
