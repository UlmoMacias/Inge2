package com.CLOPEWOPSoft.Facturas.Api.CustomerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;
import com.CLOPEWOPSoft.Facturas.Api.CustomerService.repository.RegionRepository;
import com.CLOPEWOPSoft.Facturas.Api.ExceptionHandling.ApiException;


@Service
public class ServiceRegionImp implements ServiceRegion {
	
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public List<Region> getRegions() {
		return regionRepository.findAll();
	}

	@Override
	public Region getRegion(Integer id) {
		try {
			Region r = ((Optional<Region>) regionRepository.findById(id)).get();
			return r;
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void createRegion(Region region) {
		regionRepository.save(region);
	}

	@Override
	public void updateRegion(Region region, Integer id) {
		try {
			regionRepository.updateRegion(region.getRegion(),id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteRegion(Integer id) {
		try {
			regionRepository.deleteById(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
}
