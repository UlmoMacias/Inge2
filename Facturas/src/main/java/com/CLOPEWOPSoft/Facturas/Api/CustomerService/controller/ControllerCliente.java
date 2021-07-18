package com.CLOPEWOPSoft.Facturas.Api.CustomerService.controller;

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

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Cliente;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.service.ServiceCliente;
import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<>(serviceCliente.getClientes(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Integer id){
		return new ResponseEntity<>(serviceCliente.getCliente(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createCliente(@Valid @RequestBody Cliente cliente, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceCliente.createCliente(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateCliente(@Valid @RequestBody Cliente cliente, @PathVariable("id") Integer id, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceCliente.updateCliente(cliente, id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") Integer id){
		serviceCliente.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
