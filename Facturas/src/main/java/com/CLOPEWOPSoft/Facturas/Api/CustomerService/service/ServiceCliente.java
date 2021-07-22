package com.CLOPEWOPSoft.Facturas.Api.CustomerService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Cliente;

public interface ServiceCliente {

	public List<Cliente> getClientes();
	
	public Cliente getCliente(String rfc);
	
	public void createCliente(Cliente cliente);
	
	public void updateCliente(Cliente cliente, Integer id);
	
	public void deleteCliente(Integer id);
}
