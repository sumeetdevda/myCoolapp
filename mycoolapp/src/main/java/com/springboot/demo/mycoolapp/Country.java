package com.springboot.demo.mycoolapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {
	
	@Id
	@Column  
	private String id;
	@Column  
	private String countryName;
	@Column  
	private String countryCapital;
	@Column  
	private String countryRegion;
	@Column  
	private String defaultCurencyCode;
	@Column  
	private String defaultCurencyName;
	@Column  
	private String defaultCurencySymbol;
	@Column  
	private String defaultLanguagesName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getDefaultCurencyCode() {
		return defaultCurencyCode;
	}

	public void setDefaultCurencyCode(String defaultCurencyCode) {
		this.defaultCurencyCode = defaultCurencyCode;
	}

	public String getDefaultCurencyName() {
		return defaultCurencyName;
	}

	public void setDefaultCurencyName(String defaultCurencyName) {
		this.defaultCurencyName = defaultCurencyName;
	}

	public String getDefaultCurencySymbol() {
		return defaultCurencySymbol;
	}

	public void setDefaultCurencySymbol(String defaultCurencySymbol) {
		this.defaultCurencySymbol = defaultCurencySymbol;
	}

	public String getDefaultLanguagesName() {
		return defaultLanguagesName;
	}

	public void setDefaultLanguagesName(String defaultLanguagesName) {
		this.defaultLanguagesName = defaultLanguagesName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCapital == null) ? 0 : countryCapital.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((countryRegion == null) ? 0 : countryRegion.hashCode());
		result = prime * result + ((defaultCurencyCode == null) ? 0 : defaultCurencyCode.hashCode());
		result = prime * result + ((defaultCurencyName == null) ? 0 : defaultCurencyName.hashCode());
		result = prime * result + ((defaultCurencySymbol == null) ? 0 : defaultCurencySymbol.hashCode());
		result = prime * result + ((defaultLanguagesName == null) ? 0 : defaultLanguagesName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Country other = (Country) obj;
		if (countryCapital == null) {
			if (other.countryCapital != null)
				return false;
		} else if (!countryCapital.equals(other.countryCapital))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (countryRegion == null) {
			if (other.countryRegion != null)
				return false;
		} else if (!countryRegion.equals(other.countryRegion))
			return false;
		if (defaultCurencyCode == null) {
			if (other.defaultCurencyCode != null)
				return false;
		} else if (!defaultCurencyCode.equals(other.defaultCurencyCode))
			return false;
		if (defaultCurencyName == null) {
			if (other.defaultCurencyName != null)
				return false;
		} else if (!defaultCurencyName.equals(other.defaultCurencyName))
			return false;
		if (defaultCurencySymbol == null) {
			if (other.defaultCurencySymbol != null)
				return false;
		} else if (!defaultCurencySymbol.equals(other.defaultCurencySymbol))
			return false;
		if (defaultLanguagesName == null) {
			if (other.defaultLanguagesName != null)
				return false;
		} else if (!defaultLanguagesName.equals(other.defaultLanguagesName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", countryCapital=" + countryCapital
				+ ", countryRegion=" + countryRegion + ", defaultCurencyCode=" + defaultCurencyCode
				+ ", defaultCurencyName=" + defaultCurencyName + ", defaultCurencySymbol=" + defaultCurencySymbol
				+ ", defaultLanguagesName=" + defaultLanguagesName + "]";
	}
	
	
	
}
