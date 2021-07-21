package com.CLOPEWOPSoft.Facturas.Api.ProductService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.service.ServiceProducto;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {

	@Autowired
	ServiceProducto serviceProducto;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getProductos(){
		return new ResponseEntity<>(serviceProducto.getProductos(),HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Producto> getProducto(@PathVariable("codigo") String codigo){
		return new ResponseEntity<>(serviceProducto.getProducto(codigo),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createProducot(@Valid @RequestBody Producto producto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceProducto.createProducto(producto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<HttpStatus> updateProduct(@Valid @RequestBody Producto producto, @PathVariable("codigo") String codigo, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceProducto.updateProducto(producto, codigo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("codigo") String codigo){
		serviceProducto.deleteProducto(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}