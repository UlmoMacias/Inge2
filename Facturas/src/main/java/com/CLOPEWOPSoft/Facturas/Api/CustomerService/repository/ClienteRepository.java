package com.CLOPEWOPSoft.Facturas.Api.CustomerService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	@Query(value = "SELECT * FROM Cliente WHERE Status = 1", nativeQuery = true)
	List<Cliente> getClientes();
	
	@Query(value = "SELECT * FROM Cliente WHERE RFC = :rfc", nativeQuery = true)
	Cliente getCliente(@Param("rfc") String rfc);
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_create_cliente(:nombres , "
			+ ":apellidos , "
			+ ":rfc ,"
			+ ":correo ,"
			+ ":idRegion)", nativeQuery = true)
	void createCliente(@Param("nombres") String nombres, 
			@Param("apellidos") String apellidos,
			@Param("rfc") String rfc,
			@Param("correo") String correo,
			@Param("idRegion") Integer idRegion);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Cliente SET Nombres = :nombres ,"
			+ "Apellidos = :apellidos ,"
			+ "RFC = :rfc ,"
			+ "correo = :correo ,"
			+ "ID_Region = :idRegion"
			+ " WHERE ID = :rfc", nativeQuery = true)
	void updateCliente(@Param("nombres") String nombres, 
			@Param("apellidos") String apellidos,
			@Param("rfc") String rfc,
			@Param("correo") String correo,
			@Param("idRegion") Integer idRegion);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Cliente SET Status = 0 WHERE RFC = :rfc", nativeQuery = true)
	void deleteCliente(@Param("rfc")String rfc);
}
