package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,String>{
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_create_articulo(:codigo , "
			+ ":cantidad ,"
			+ ":impuesto ,"
			+ ":p_id_factura )"
			, nativeQuery = true)
	void createArticulo(@Param("codigo") String codigo,
						@Param("cantidad") Integer cantidad,
						@Param("impuesto") float impuesto,
						@Param("p_id_factura") Integer p_id_factura
						);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Articulo SET "
			+ "Codigo = :codigo ,"
			+ "Cantidad = :cantidad ,"
			+ "Impuesto = :impuesto ,"
			+ "ID_Factura = :idFactura "
			+ "WHERE Codigo = :codigo", nativeQuery = true)
	void updateArticulo(
						@Param("codigo") String codigo,
						@Param("cantidad") Integer cantidad,
						@Param("impuesto") float impuesto,
						@Param("idFactura") Integer idFactura);
}
