package com.springboot.demo.mycoolapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	DataSource dataSource;
	
	public List<Country> getAllCountry()   
	{  
	List<Country> countrys = new ArrayList<Country>();  
	countryRepository.findAll().forEach(country -> countrys.add(country));  
	return countrys;  
	}  
	//getting a specific record  
	public Country getCountryById(String id)   
	{  
	return countryRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Country country)   
	{  
	countryRepository.save(country);  
	}  
	//deleting a specific record  
	public void delete(String id)   
	{  
	countryRepository.deleteById(id);  
	}  
	
	public void saveAllcountries() {
		
		List<Country> ctrs = new ArrayList<Country>() ;
		try {

			URL url = new URL("https://restcountries.eu/rest/v2/all");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			JSONArray countryList = null;
			JSONParser jsonParser = new JSONParser();
			// JSONArray employeeList = (JSONArray) employeeListObject.get("invites");
			while ((output = br.readLine()) != null) {
				
				Object obj = jsonParser.parse(output);
				countryList = (JSONArray) obj;
				
			}
			conn.disconnect();
			
			
			
			countryList.forEach(emp -> {
				CountryRes crs = parseCountryObject((JSONObject) emp);	
				Country ct = getCountryObj(crs);
				if(ct.getCountryRegion() != null && !ct.getCountryRegion().equals("")) {
					ctrs.add(getCountryObj(crs));
				}
				
			});
			
			Iterable<Country> ls = countryRepository.saveAll(ctrs);
		System.out.println(ls);
			

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		
		
	}
	
	private CountryRes parseCountryObject(JSONObject cObj) {
		CountryRes cs = new CountryRes();
	
		cs.setAlpha2Code((String)cObj.get("alpha2Code"));
		
		cs.setAlpha3Code((String)cObj.get("alpha3Code"));
		
		cs.setAltSpellings((List<String>)cObj.get("altSpellings"));
		
		// cs.setArea((double)cObj.get("area"));
		
		cs.setBorders((List<String>)cObj.get("borders"));
		
		cs.setCallingCodes((List<String>)cObj.get("callingCodes"));
		
		cs.setCapital((String)cObj.get("capital"));
		
		cs.setCioc((String)cObj.get("coic"));
		
		cs.setCurrencies((List<Map<String,Object>>)cObj.get("currencies"));
		
		cs.setDemonym((String)cObj.get("demonym"));
		
		cs.setFlag((String)cObj.get("flag"));
		
		//cs.setGini((double)cObj.get("gini"));
		
		cs.setLanguages((List<Map<String,Object>>)cObj.get("languages"));
		
		cs.setLatlng((List<Integer>)cObj.get("latlng"));
		
		cs.setName((String)cObj.get("name"));
		
		cs.setNativeName((String)cObj.get("nativeName"));
		
		cs.setNumericCode((String)cObj.get("numericCode"));
		
		cs.setPopulation((long)cObj.get("population"));
		
		cs.setRegion((String)cObj.get("region"));
		
		cs.setRegionalBlocs((List<Map<String,Object>>)cObj.get("regionalbLocs"));
		
		cs.setSubregion((String)cObj.get("subrigion"));
		
		cs.setTimezones((List<String>)cObj.get("timezones"));
		
		cs.setTopLevelDomain((List<String>) cObj.get("topLevelDomain"));
		

		return cs;

	}
	
	public Country getCountryObj(CountryRes crs) {
		Country ctr = new Country();
		
		ctr.setId(crs.getName()+"-"+crs.getCapital());
		ctr.setCountryCapital(crs.getCapital());
		ctr.setCountryName(crs.getName());
		ctr.setCountryRegion(crs.getRegion());
		ctr.setDefaultCurencyCode((String)crs.getCurrencies().get(0).get("code"));
		ctr.setDefaultCurencyName((String)crs.getCurrencies().get(0).get("name"));
		ctr.setDefaultCurencySymbol((String)crs.getCurrencies().get(0).get("symbol"));
		ctr.setDefaultLanguagesName((String)crs.getLanguages().get(0).get("name"));
		
		return ctr;
	}

}
