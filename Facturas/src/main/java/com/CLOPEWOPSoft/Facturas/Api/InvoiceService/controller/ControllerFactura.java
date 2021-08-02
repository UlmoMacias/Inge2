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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Factura;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service.ServiceFactura;

@RestController
@RequestMapping("/factura")
public class ControllerFactura {

	@Autowired
	ServiceFactura serviceFactura;
	
	@GetMapping
	public ResponseEntity<List<Factura>> getFacturas(){
		return new ResponseEntity<>(serviceFactura.getFacturas(),HttpStatus.OK);
	}
	
	@GetMapping("/{rfc}")
	public ResponseEntity<List<Factura>> getFacturas(@PathVariable("rfc") String rfc){
		return new ResponseEntity<>(serviceFactura.getFacturas(rfc),HttpStatus.OK);
	}
	
	/*@GetMapping("/{id}")
	public ResponseEntity<Factura> getFactura(@PathVariable("id") Integer id){
		return new ResponseEntity<>(serviceFactura.getFactura(id), HttpStatus.OK);
	}*/
	
	@PostMapping
	public ResponseEntity<HttpStatus> createFactura(@Valid @RequestBody Factura factura, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceFactura.createFactura(factura);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//NO HAY UPDATE
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteFactura(@PathVariable("id") Integer id){
		serviceFactura.deleteFactura(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
