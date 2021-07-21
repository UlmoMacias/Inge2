package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;

public interface ServiceArticulo {

	public List<Articulo> getArticulos();
	
	public Articulo getArticulo(String codigo);
	
	public void createArticulo(Articulo articulo);
	
	public void updateArticulo(Articulo articulo, String codigo);
	
	public void deleteArticulo(String codigo);
}
