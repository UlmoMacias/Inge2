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

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.service.ServiceRegion;
import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;

@RestController
@RequestMapping("/region")
public class ControllerRegion {

	@Autowired
	ServiceRegion serviceRegion;
	
	@GetMapping
	public ResponseEntity<List<Region>> getRegions(){
		return new ResponseEntity<>(serviceRegion.getRegions(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Region> getRegion(@PathVariable("id") Integer id){
		return new ResponseEntity<>(serviceRegion.getRegion(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createRegion(@Valid @RequestBody Region region, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceRegion.createRegion(region);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateRegion(@Valid @RequestBody Region region, @PathVariable Integer id, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST,bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		serviceRegion.updateRegion(region, id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteRegion(@PathVariable Integer id){
		serviceRegion.deleteRegion(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
