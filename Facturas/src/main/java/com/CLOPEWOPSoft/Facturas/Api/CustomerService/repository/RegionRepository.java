package com.CLOPEWOPSoft.Facturas.Api.CustomerService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer>{
	
	@Query(value = "SELECT * FROM Region WHERE Status = 1", nativeQuery = true)
	List<Region> getRegions();
	
	@Query(value = "SELECT * FROM Region WHERE Status = 1 AND ID = :id", nativeQuery = true)
	Region getRegion(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_create_region(:region)", nativeQuery = true)
	void createRegion(@Param("region") String region);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Region SET Region = :region WHERE ID = :id", nativeQuery = true)
	void updateRegion(@Param("region") String region, @Param("id")Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "CALL st_delete_region(:id)", nativeQuery = true)
	void deleteRegion(@Param("id")Integer id);
	
}
