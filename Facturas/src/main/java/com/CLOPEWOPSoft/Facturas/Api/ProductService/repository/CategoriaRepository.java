package com.CLOPEWOPSoft.Facturas.Api.ProductService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

	@Query(value = "SELECT * FROM Categoria WHERE Status = 1", nativeQuery = true)
	List<Categoria> getCategorias();
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_create_categoria(:categoria)", nativeQuery = true)
	void createCategoria(@Param("categoria") String categoria);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Categoria SET Categoria = :categoria WHERE ID = :id", nativeQuery = true)
	void updateCategoria(@Param("categoria") String categoria, @Param("id") Integer id);

	@Modifying
	@Transactional
	@Query(value = "CALL st_delete_categoria(:id)", nativeQuery = true)
	void deleteCategoria(@Param("id")Integer id);
}
