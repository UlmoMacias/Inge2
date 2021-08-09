package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;
import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.repository.ArticuloRepository;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.service.ServiceProducto;

@Service
public class ServiceArticuloImp implements ServiceArticulo {
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	
	@Autowired
	ServiceProducto sp;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Articulo> getArticulos() {
		return articuloRepository.findAll();
	}

	@Override
	public Articulo getArticulo(Integer id) {
		try {
			Articulo a = ((Optional<Articulo>) articuloRepository.findById(id)).get();
			setCostosArticulo(a);
			return a;
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void createArticulo(Articulo articulo) {
		articuloRepository.createArticulo(
										articulo.getCodigo(),
										articulo.getCantidad(),
										articulo.getImpuesto(),
										articulo.getIdFactura());
	}

	@Override
	public void updateArticulo(Articulo articulo, Integer id) {
		try {
			articuloRepository.updateArticulo(
											articulo.getCodigo(), 
											articulo.getCantidad(), 
											articulo.getImpuesto(), 
											articulo.getIdFactura(),
											id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteArticulo(Integer id) {
		try {
			articuloRepository.deleteById(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
	
	private Producto getCodigoProducto(String codigo) {
		try {
			return sp.getProductoA(codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,"El id "+ codigo+" no es valido");
		}
	}
	
	public void setCostosArticulo(Articulo articulo) {
		Producto p = getCodigoProducto(articulo.getCodigo());
		articulo.setPrecioUnitario(p.getPrecio());
		articulo.setSubTotal(p.getPrecio()*articulo.getCantidad());
		System.out.println(articulo.getSubTotal());
		articulo.setTotal(articulo.getSubTotal()*(1+articulo.getImpuesto()));
	}

}
