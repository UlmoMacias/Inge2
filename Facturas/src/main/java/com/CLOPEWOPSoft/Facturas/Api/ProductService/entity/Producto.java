package com.CLOPEWOPSoft.Facturas.Api.ProductService.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("codigo")
	@Column(name = "Codigo")
	@NotNull(message = "Se necesita un codigo para el producto")
	private String Codigo;
	
	@JsonProperty("nombre")
	@Column(name = "Nombre")
	@NotNull(message = "Se necesita el nombre del producto")
	private String nombre;
	
	@JsonProperty("descripcion")
	@Column(name = "Descripcion")
	@NotNull(message = "Se necesita una descripcion del producto")
	private String descripcion;
	
	@JsonProperty("cantidad")
	@Column(name = "Cantidad")
	@NotNull(message = "Se necesita una cantidad del producto")
	@Min(value = 0, message = "La minima cantidad es 0")
	private Integer cantidad;
	
	@JsonProperty("precio")
	@Column(name = "Precio")
	@NotNull(message = "Se necesita el precio del producto")
	@Min(value = 0, message = "El precio minimo es 0" )
	private float precio;
	
	@JsonProperty("fecha_creacion")
	@Column(name = "fecha_creacion")
	@NotNull(message = "La fecha es necesaria")
	private LocalDate fechaCreacion;
	
	@JsonProperty("id_categoria")
	@Valid
	@ManyToOne
	@JoinColumn(name = "ID_Categoria")
	private Categoria categoria;
}
