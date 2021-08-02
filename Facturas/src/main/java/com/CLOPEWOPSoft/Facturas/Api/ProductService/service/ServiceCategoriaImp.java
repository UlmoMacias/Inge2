package com.CLOPEWOPSoft.Facturas.Api.ProductService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Categoria;
import com.CLOPEWOPSoft.Facturas.Api.ProductService.repository.CategoriaRepository;

@Service
public class ServiceCategoriaImp implements ServiceCategoria {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Categoria> getCategorias() {
		return categoriaRepository.getCategorias();
	}

	@Override
	public Categoria getCategoria(Integer id) {
		try {
			Categoria c  = ((Optional<Categoria>) categoriaRepository.findById(id)).get();
			return c;
		}catch(Exception e){
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void createCategoria(Categoria categoria) {
		categoriaRepository.createCategoria(categoria.getCategoria());
	}

	@Override
	public void updateCategoria(Categoria categoria, Integer id) {
		try {
			categoriaRepository.updateCategoria(categoria.getCategoria(), id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteCategoria(Integer id) {
		try {
			categoriaRepository.deleteCategoria(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
}
