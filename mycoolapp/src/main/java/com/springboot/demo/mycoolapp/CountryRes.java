package com.springboot.demo.mycoolapp;

import java.util.List;
import java.util.Map;

public class CountryRes {
	
	private String alpha2Code ;
	private String alpha3Code ;
	private List<String> altSpellings ;
	private double area ;
	private List<String> borders ;
	private List<String> callingCodes ;
	private String capital ;
	private String cioc ;
	private List<Map<String,Object>> currencies ;
	private String demonym ;
	private String flag ;
	private double gini ;
	private List<Map<String,Object>> languages ;
	private List<Integer> latlng ;
	private String name ;
	private String nativeName ;
	private String numericCode ;
	private long population ;
	private String region ;
	private List<Map<String,Object>> regionalBlocs ;
	private String subregion ;
	private List<String> timezones ;
	private List<String> topLevelDomain ;
	public String getAlpha2Code() {
		return alpha2Code;
	}
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}
	public String getAlpha3Code() {
		return alpha3Code;
	}
	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}
	public List<String> getAltSpellings() {
		return altSpellings;
	}
	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public List<String> getBorders() {
		return borders;
	}
	public void setBorders(List<String> borders) {
		this.borders = borders;
	}
	public List<String> getCallingCodes() {
		return callingCodes;
	}
	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCioc() {
		return cioc;
	}
	public void setCioc(String cioc) {
		this.cioc = cioc;
	}
	public List<Map<String, Object>> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Map<String, Object>> currencies) {
		this.currencies = currencies;
	}
	public String getDemonym() {
		return demonym;
	}
	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public double getGini() {
		return gini;
	}
	public void setGini(double gini) {
		this.gini = gini;
	}
	public List<Map<String, Object>> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Map<String, Object>> languages) {
		this.languages = languages;
	}
	public List<Integer> getLatlng() {
		return latlng;
	}
	public void setLatlng(List<Integer> latlng) {
		this.latlng = latlng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getNumericCode() {
		return numericCode;
	}
	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<Map<String, Object>> getRegionalBlocs() {
		return regionalBlocs;
	}
	public void setRegionalBlocs(List<Map<String, Object>> regionalBlocs) {
		this.regionalBlocs = regionalBlocs;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public List<String> getTimezones() {
		return timezones;
	}
	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}
	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}
	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alpha2Code == null) ? 0 : alpha2Code.hashCode());
		result = prime * result + ((alpha3Code == null) ? 0 : alpha3Code.hashCode());
		result = prime * result + ((altSpellings == null) ? 0 : altSpellings.hashCode());
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((borders == null) ? 0 : borders.hashCode());
		result = prime * result + ((callingCodes == null) ? 0 : callingCodes.hashCode());
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((cioc == null) ? 0 : cioc.hashCode());
		result = prime * result + ((currencies == null) ? 0 : currencies.hashCode());
		result = prime * result + ((demonym == null) ? 0 : demonym.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());

		temp = Double.doubleToLongBits(gini);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((latlng == null) ? 0 : latlng.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nativeName == null) ? 0 : nativeName.hashCode());
		result = prime * result + ((numericCode == null) ? 0 : numericCode.hashCode());
		result = prime * result + (int) (population ^ (population >>> 32));
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((regionalBlocs == null) ? 0 : regionalBlocs.hashCode());
		result = prime * result + ((subregion == null) ? 0 : subregion.hashCode());
		result = prime * result + ((timezones == null) ? 0 : timezones.hashCode());
		result = prime * result + ((topLevelDomain == null) ? 0 : topLevelDomain.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryRes other = (CountryRes) obj;
		if (alpha2Code == null) {
			if (other.alpha2Code != null)
				return false;
		} else if (!alpha2Code.equals(other.alpha2Code))
			return false;
		if (alpha3Code == null) {
			if (other.alpha3Code != null)
				return false;
		} else if (!alpha3Code.equals(other.alpha3Code))
			return false;
		if (altSpellings == null) {
			if (other.altSpellings != null)
				return false;
		} else if (!altSpellings.equals(other.altSpellings))
			return false;
		if (area != other.area)
			return false;
		if (borders == null) {
			if (other.borders != null)
				return false;
		} else if (!borders.equals(other.borders))
			return false;
		if (callingCodes == null) {
			if (other.callingCodes != null)
				return false;
		} else if (!callingCodes.equals(other.callingCodes))
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (cioc == null) {
			if (other.cioc != null)
				return false;
		} else if (!cioc.equals(other.cioc))
			return false;
		if (currencies == null) {
			if (other.currencies != null)
				return false;
		} else if (!currencies.equals(other.currencies))
			return false;
		if (demonym == null) {
			if (other.demonym != null)
				return false;
		} else if (!demonym.equals(other.demonym))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (Double.doubleToLongBits(gini) != Double.doubleToLongBits(other.gini))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (latlng == null) {
			if (other.latlng != null)
				return false;
		} else if (!latlng.equals(other.latlng))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nativeName == null) {
			if (other.nativeName != null)
				return false;
		} else if (!nativeName.equals(other.nativeName))
			return false;
		if (numericCode == null) {
			if (other.numericCode != null)
				return false;
		} else if (!numericCode.equals(other.numericCode))
			return false;
		if (population != other.population)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (regionalBlocs == null) {
			if (other.regionalBlocs != null)
				return false;
		} else if (!regionalBlocs.equals(other.regionalBlocs))
			return false;
		if (subregion == null) {
			if (other.subregion != null)
				return false;
		} else if (!subregion.equals(other.subregion))
			return false;
		if (timezones == null) {
			if (other.timezones != null)
				return false;
		} else if (!timezones.equals(other.timezones))
			return false;
		if (topLevelDomain == null) {
			if (other.topLevelDomain != null)
				return false;
		} else if (!topLevelDomain.equals(other.topLevelDomain))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CountryRes [alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + ", altSpellings=" + altSpellings
				+ ", area=" + area + ", borders=" + borders + ", callingCodes=" + callingCodes + ", capital=" + capital
				+ ", cioc=" + cioc + ", currencies=" + currencies + ", demonym=" + demonym + ", flag=" + flag
				+ ", gini=" + gini + ", languages=" + languages + ", latlng=" + latlng + ", name=" + name
				+ ", nativeName=" + nativeName + ", numericCode=" + numericCode + ", population=" + population
				+ ", region=" + region + ", regionalBlocs=" + regionalBlocs + ", subregion=" + subregion
				+ ", timezones=" + timezones + ", topLevelDomain=" + topLevelDomain + "]";
	}
	
	
	
}
