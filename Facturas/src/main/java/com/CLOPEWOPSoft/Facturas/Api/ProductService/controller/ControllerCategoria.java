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
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Categoria;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.service.ServiceCategoria;

@RestController
@RequestMapping("/categoria")
public class ControllerCategoria {

	@Autowired
	ServiceCategoria serviceCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategorias(){
		return new ResponseEntity<>(serviceCategoria.getCategorias(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable("id") Integer id){
		return new ResponseEntity<>(serviceCategoria.getCategoria(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createCategoria(@Valid @RequestBody Categoria categoria, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceCategoria.createCategoria(categoria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateCategoria(@Valid @RequestBody Categoria categoria,  BindingResult bindingResult, @PathVariable("id") Integer id){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceCategoria.updateCategoria(categoria, id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") Integer id){
		serviceCategoria.deleteCategoria(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
