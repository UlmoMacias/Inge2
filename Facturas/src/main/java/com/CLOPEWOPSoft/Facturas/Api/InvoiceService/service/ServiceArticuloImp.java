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
	public Articulo getArticulo(String codigo) {
		try {
			Articulo a = ((Optional<Articulo>) articuloRepository.findById(codigo)).get();
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
	public void updateArticulo(Articulo articulo, String codigo) {
		try {
			articuloRepository.updateArticulo(
											articulo.getCodigo(), 
											articulo.getCantidad(), 
											articulo.getImpuesto(), 
											articulo.getIdFactura());
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteArticulo(String codigo) {
		try {
			articuloRepository.deleteById(codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
	
	private Producto getCodigoProducto(String codigo) {
		try {
			/*ResponseEntity<Producto> response = restTemplate.getForEntity(
					"http://localhost:8080/product/"+id, Producto.class);
			return response.getBody();*/
			
			return sp.getProducto(codigo);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,"El id "+ codigo+" no es valido");
		}
	}
	
	private void setCostosArticulo(Articulo articulo) {
		Producto p = getCodigoProducto(articulo.getCodigo());
		articulo.setPrecioUnitario(p.getPrecio());
		articulo.setSubTotal(p.getPrecio()*articulo.getCantidad());
		System.out.println(articulo.getSubTotal());
		articulo.setTotal(articulo.getSubTotal()*(1+articulo.getImpuesto()));
	}

}
