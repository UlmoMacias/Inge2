package com.CLOPEWOPSoft.Facturas.Api.ProductService.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Producto SET "
			+ "Codigo = :codigo ,"
			+ "Nombre = :nombre ,"
			+ "Descripcion = :descripcion ,"
			+ "Cantidad = :cantidad ,"
			+ "Precio = :precio ,"
			+ "fecha_creacion = :fechaCreacion ,"
			+ "ID_Categoria = :idCategoria "
			+ "WHERE ID = :id", nativeQuery = true)
	void updateProducto(@Param("codigo") String codigo,
						@Param("nombre") String nombre,
						@Param("descripcion") String descripcion,
						@Param("cantidad") Integer cantidad,
						@Param("precio") float precio,
						@Param("fechaCreacion") LocalDate fechaCreacion,
						@Param("idCategoria") Integer idCategoria,
						@Param("id") Integer id);
}
