package com.springboot.demo.mycoolapp;

public class CountryCount {
	
	private String countryRegion;
	
	private long count;

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + ((countryRegion == null) ? 0 : countryRegion.hashCode());
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
		CountryCount other = (CountryCount) obj;
		if (count != other.count)
			return false;
		if (countryRegion == null) {
			if (other.countryRegion != null)
				return false;
		} else if (!countryRegion.equals(other.countryRegion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CountryCount [countryRegion=" + countryRegion + ", count=" + count + "]";
	}

}
