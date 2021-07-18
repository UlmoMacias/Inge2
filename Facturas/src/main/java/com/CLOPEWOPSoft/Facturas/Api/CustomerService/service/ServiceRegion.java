package com.CLOPEWOPSoft.Facturas.Api.CustomerService.service;

import java.util.List;

import com.CLOPEWOPSoft.Facturas.Api.CustomerService.entity.Region;

public interface ServiceRegion {
	
	public List<Region> getRegions();
	
	public Region getRegion(Integer id);
	
	public void createRegion(Region region);
	
	public void updateRegion(Region region, Integer id);
	
	public void deleteRegion(Integer id);

}
