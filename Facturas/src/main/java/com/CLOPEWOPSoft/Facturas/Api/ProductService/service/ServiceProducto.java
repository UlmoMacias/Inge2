package com.CLOPEWOPSoft.Facturas.Api.ProductService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;

public interface ServiceProducto {

public List<Producto> getProductos();
	
	public Producto getProducto(Integer id);
	
	public void createProducto(Producto producto);
	
	public void updateProducto(Producto producto, Integer id);
	
	public void deleteProducto(Integer id);
}