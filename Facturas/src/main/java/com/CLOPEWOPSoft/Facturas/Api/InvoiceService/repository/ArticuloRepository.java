package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Articulo SET "
			+ "Codigo = :codigo ,"
			+ "Cantidad = :cantidad ,"
			+ "Impuesto = :impuesto ,"
			+ "Precio_Unitario = :precioUnitario ,"
			+ "ID_Factura = :idFactura "
			+ "WHERE ID = :id", nativeQuery = true)
	void updateArticulo(
						@Param("codigo") String codigo,
						@Param("cantidad") Integer cantidad,
						@Param("impuesto") float impuesto,
						@Param("precioUnitario") float precioUnitario,
						@Param("idFactura") Integer idFactura,
						@Param("id") Integer id);
}
