package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("cantidad")
	@Column(name = "Cantidad")
	@NotNull(message = "La canidad es necesaria")
	@Min(value = 1, message = "La cantidad debe ser positiva")
	private Integer cantidad;
	
	@JsonProperty("codigo")
	@Column(name = "Codigo")
	@NotNull(message = "El codigo del articulo es requerido")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "El codigo del articulo solo puede contener caracteres alfanumericos")
	private String codigo;
	
	@JsonProperty("impuesto")
	@Column(name = "Impuesto")
	@NotNull(message = "Debe existir un impuesto")
	@Min(value = 0, message = "El minimo impuesto es 0")
	private float impuesto;
	
	@JsonProperty("precio_unitario")
	@Transient
	private float precioUnitario;
	
	@JsonProperty("subtotal")
	@Transient
	private float subTotal;
	
	@JsonProperty("total")
	@Transient
	private float total;
	
	@JsonProperty("id_factura")
	@Column(name = "ID_Factura")
	private Integer idFactura;
}
