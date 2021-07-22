package com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**

* The class defines the structur of Regions, as well as its attributes

* And output

* @version 1.0

*/

@Data
@Entity
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("region")
	@NotNull(message = "El nombre de la region es requerida")
	@Column(name = "Region")
	private String region;
}
