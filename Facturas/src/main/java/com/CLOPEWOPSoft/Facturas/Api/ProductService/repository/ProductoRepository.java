package com.CLOPEWOPSoft.Facturas.Api.ProductService.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CLOPEWOPSoft.Facturas.Api.ProductService.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,String>{
	
	@Query(value = "SELECT * FROM Producto WHERE Status = 1", nativeQuery = true)
	List<Producto> getProductos();
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_create_producto(:codigo , "
			+ ":nombre ,"
			+ ":descripcion ,"
			+ ":cantidad ,"
			+ ":precio ,"
			+ ":fechaCreacion ,"
			+ ":idCategoria )", nativeQuery = true)
	void createProducto(@Param("codigo") String codigo,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("cantidad") Integer cantidad,
			@Param("precio") float precio,
			@Param("fechaCreacion") LocalDate fechaCreacion,
			@Param("idCategoria") Integer idCategoria);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Producto SET "
			+ "Nombre = :nombre ,"
			+ "Descripcion = :descripcion ,"
			+ "Cantidad = :cantidad ,"
			+ "Precio = :precio ,"
			+ "fecha_creacion = :fechaCreacion ,"
			+ "ID_Categoria = :idCategoria "
			+ "WHERE Codigo = :codigo", nativeQuery = true)
	void updateProducto(@Param("nombre") String nombre,
						@Param("descripcion") String descripcion,
						@Param("cantidad") Integer cantidad,
						@Param("precio") float precio,
						@Param("fechaCreacion") LocalDate fechaCreacion,
						@Param("idCategoria") Integer idCategoria,
						@Param("codigo") String codigo);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Producto SET Status = 0 WHERE Codigo = :codigo", nativeQuery = true)
	void deleteProducto(@Param("codigo") String codigo);
}
