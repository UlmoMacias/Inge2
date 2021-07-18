package com.CLOPEWOPSoft.Facturas.Api.ProductService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Categoria;

public interface ServiceCategoria {

	public List<Categoria> getCategorias();
	
	public Categoria getCategoria(Integer id);
	
	public void createCategoria(Categoria categoria);
	
	public void updateCategoria(Categoria categoria, Integer id);
	
	public void deleteCategoria(Integer id);
}
