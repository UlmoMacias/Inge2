package com.CLOPEWOPSoft.Facturas.Api.ProductService.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

	@Modifying
	@Transactional
	@Query(value = "UPDATE Categoria SET Categoria = :categoria WHERE ID = :id", nativeQuery = true)
	void updateCategoria(@Param("categoria") String categoria, @Param("id") Integer id);

}
