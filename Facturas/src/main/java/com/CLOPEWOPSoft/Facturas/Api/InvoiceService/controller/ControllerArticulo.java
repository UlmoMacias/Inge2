package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.controller;

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
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service.ServiceArticulo;

@RestController
@RequestMapping("/articulo")
public class ControllerArticulo {

	@Autowired
	ServiceArticulo serviceArticulo;
	
	@GetMapping
	public ResponseEntity<List<Articulo>> getArticulos(){
		return new ResponseEntity<>(serviceArticulo.getArticulos(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Articulo> getArticulo(@PathVariable("id") Integer id){
		return new ResponseEntity<>(serviceArticulo.getArticulo(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createArticulo(@Valid @RequestBody Articulo articulo, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceArticulo.createArticulo(articulo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateArticulo(@Valid @RequestBody Articulo articulo, BindingResult bindingResult, @PathVariable("id") Integer id){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceArticulo.updateArticulo(articulo, id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteMapping(@PathVariable Integer id){
		serviceArticulo.deleteArticulo(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
