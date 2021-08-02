package com.CLOPEWOPSoft.Facturas.Api.InvoiceService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.InvoiceService.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer>{

	@Query(value = "SELECT * FROM Factura WHERE Status = 1", nativeQuery = true)
	List<Factura> getFacturas();
	
	@Query(value = "SELECT * FROM Factura WHERE Status = 1 AND RFC_Cliente = :rfc", nativeQuery = true)
	List<Factura> getFacturas(@Param("rfc") String rfc);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Factura SET Status = 0 WHERE ID = :id", nativeQuery = true)
	void deleteFactura(@Param("id") Integer id);
}
