package com.CLOPEWOPSoft.Facturas.Api.CustomerService.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Cliente;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.repository.ClienteRepository;
import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;

@Service
public class ServiceClienteImp implements ServiceCliente {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getCliente(String rfc) {
		try {
			//java.util.Optional<Cliente> c = clienteRepository.findById(id);
			//return c.get();
			return clienteRepository.getCliente(rfc);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void createCliente(Cliente cliente) {
		clienteRepository.createCliente(
				cliente.getNombres(), 
				cliente.getApellidos(), 
				cliente.getRfc(), 
				cliente.getCorreo(), 
				cliente.getIdRegion().getId());;
	}

	@Override
	public void updateCliente(Cliente cliente, Integer id) {
		try {
			clienteRepository.updateCliente(cliente.getNombres(), 
					cliente.getApellidos(),
					cliente.getRfc(), 
					cliente.getCorreo(), 
					cliente.getIdRegion().getId(), 
					id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteCliente(Integer id) {
		try {
			clienteRepository.deleteById(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

}
