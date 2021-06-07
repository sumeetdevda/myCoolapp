package com.springboot.demo.mycoolapp;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String>{

	@Query("SELECT c FROM Country c WHERE c.countryRegion LIKE %?1%")
    public List<Country> search(String keyword);
	
	@Query("select c.countryRegion ,count(c.countryName) as count from Country c where c.countryRegion is not null group by c.countryRegion ")
	public List<Object> regionCount();
	
	@Query("SELECT DISTINCT C.countryRegion FROM Country C WHERE C.countryRegion IS NOT NULL")
	public List<Object> region();
}
