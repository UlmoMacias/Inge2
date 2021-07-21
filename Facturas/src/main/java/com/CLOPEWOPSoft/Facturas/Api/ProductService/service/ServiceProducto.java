package com.CLOPEWOPSoft.Facturas.Api.ProductService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;

public interface ServiceProducto {

public List<Producto> getProductos();
	
	public Producto getProducto(String codigo);
	
	public void createProducto(Producto producto);
	
	public void updateProducto(Producto producto, String codigo);
	
	public void deleteProducto(String codigo);
}