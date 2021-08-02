package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("fecha_creacion")
	@Column(name = "FechaCreacion")
	private LocalDate fechaCreacion;
	
	@JsonIgnore
	private Integer status;
	
	@JsonProperty("rfc_cliente")
	@NotNull(message = "Debe existir un RFC para el cliente")
	@Column(name = "RFC_Cliente")
	private String RFC_Cliente;
	
	@JsonProperty("subtotal")
	@Transient
	private Double subtotal;
	
	@JsonProperty("impuestos")
	@Transient
	private Double impuestos;
	
	@JsonProperty("total")
	@Transient
	private Double total;
	
	@JsonProperty("articulos")
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_factura",referencedColumnName="ID")
	private List<Articulo> articulos;
}
