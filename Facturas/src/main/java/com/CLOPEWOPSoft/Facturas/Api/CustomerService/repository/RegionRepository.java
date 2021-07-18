package com.CLOPEWOPSoft.Facturas.Api.CustomerService.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Region SET Region = :region WHERE ID = :id", nativeQuery = true)
	void updateRegion(@Param("region") String region, @Param("id")Integer id);
}
