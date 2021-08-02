package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Factura;

public interface ServiceFactura {

	public List<Factura> getFacturas();
	
	public List<Factura> getFacturas(String rfc);
	
	public Factura getFactura(Integer id);
	
	public void createFactura(Factura factura);
	
	//NO HAY UPDATE
	
	public void deleteFactura(Integer id);
}
