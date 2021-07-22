package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Cliente;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.service.ServiceCliente;
import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Factura;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.repository.FacturaRepository;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.service.ServiceProducto;

@Service
public class ServiceFacturaImp implements ServiceFactura {

	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ServiceCliente sc;
	
	@Autowired
	ServiceProducto sp;
	
	@Override
	public List<Factura> getFacturas() {
		try {
			List<Factura> facturas = facturaRepository.getFacturas();
			for(Factura f : facturas) {
				setCostosFactura(f);
			}
			return facturas;
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}

	@Override
	public Factura getFactura(Integer id) {
		try {
			Factura f = ((Optional<Factura>) facturaRepository.findById(id)).get();
			setCostosFactura(f);
			return f;
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}

	@Override
	public void createFactura(Factura factura) {
		try {
			getCliente(factura.getRFC_Cliente());
			
			for(Articulo a : factura.getArticulos()) {
				System.out.println(a.getCodigo());
				getProducto(a.getCodigo());
			}
			
			factura.setStatus(1);
			factura.setFechaCreacion(LocalDate.now());
			facturaRepository.save(factura);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteFactura(Integer id) {
		try {
			getFactura(id);
			facturaRepository.deleteFactura(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	private Cliente getCliente(String rfc) {
		try {
			return sc.getCliente(rfc);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,"RFC "+ rfc+" no es valido");
		}
	}
	
	private Producto getProducto(String codigo) {
		try {
			return sp.getProducto(codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,"El id "+ codigo+" no es valido");
		}
	}
	
	private void setCostosFactura(Factura factura) {
		if(factura.getStatus() != 1) {
			throw new ApiException(HttpStatus.BAD_REQUEST,"La factura ha sido cancelada");
		}
		
		Double subtotal = 0.0;
		Double taxes = 0.0;
		
		for(Articulo a: factura.getArticulos()) {
			setCostosArticulo(a);
			subtotal += a.getSubTotal();
			taxes += a.getSubTotal() *a.getImpuesto();
		}
		
		factura.setSubtotal(subtotal);
		factura.setImpuestos(taxes);
		factura.setTotal(subtotal+taxes);
	}
	
	private void setCostosArticulo(Articulo articulo) {
		Producto p = getProducto(articulo.getCodigo());
		articulo.setPrecioUnitario(p.getPrecio());
		articulo.setSubTotal(p.getPrecio()*articulo.getCantidad());
		articulo.setTotal(articulo.getSubTotal()*(1+articulo.getImpuesto()));
	}

}
