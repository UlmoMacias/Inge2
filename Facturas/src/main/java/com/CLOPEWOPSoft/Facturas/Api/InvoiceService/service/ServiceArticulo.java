package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;

public interface ServiceArticulo {

	public List<Articulo> getArticulos();
	
	public Articulo getArticulo(Integer id);
	
	public void createArticulo(Articulo articulo);
	
	public void updateArticulo(Articulo articulo, Integer id);
	
	public void deleteArticulo(Integer id);
}
