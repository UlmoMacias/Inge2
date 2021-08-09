package com.CLOPEWOPSoft.Facturas.Api.ProductService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.repository.ProductoRepository;

@Service
public class ServiceProductoImp implements ServiceProducto {

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Producto> getProductos() {
		return productoRepository.getProductos();
	}
	
	@Override
	public Producto getProducto(String codigo) {
		return productoRepository.getProducto(codigo);
	}
	@Override
	public Producto getProductoA(String codigo) {
		try {
			Producto p  = ((Optional<Producto>) productoRepository.findById(codigo)).get();
			return p;
		}catch(Exception e){
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void createProducto(Producto producto) {
		productoRepository.createProducto(
										producto.getCodigo(),
										producto.getNombre(), 
										producto.getDescripcion(), 
										producto.getCantidad(), 
										producto.getPrecio(), 
										producto.getFechaCreacion(), 
										producto.getCategoria().getId());
	}

	@Override
	public void updateProducto(Producto producto, String codigo) {
		System.out.println("Hola");
		try {
			productoRepository.updateProducto(
											producto.getNombre(), 
											producto.getDescripcion(), 
											producto.getCantidad(), 
											producto.getPrecio(), 
											producto.getFechaCreacion(), 
											producto.getCategoria().getId(), 
											codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteProducto(String codigo) {
		try {
			productoRepository.deleteProducto(codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
}
