package com.springboot.demo.mycoolapp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.mycoolapp.Country;
import com.springboot.demo.mycoolapp.CountryCount;
import com.springboot.demo.mycoolapp.CountryRepository;
import com.springboot.demo.mycoolapp.CountryService;

@RestController
public class FunRestontroller {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	DataSource dataSource;

	@Autowired
	CountryService countryService;

	@RequestMapping("/")
	public String sayHello() {
		countryService.saveAllcountries();

		StringBuffer sbf = new StringBuffer();
		sbf.append("<html>");
		sbf.append("<body>");
		sbf.append("<h2>Hello and welcome to country App</h2>");
		sbf.append("<h3>please use below Links to access the details</h3>");
		sbf.append("<ul>");
		sbf.append("<li>");
		sbf.append(" <a href=/getAllCountries>Click here To get list of all countries <span style=\" color:red\">This step is mendatory to check other</span></a>");
		sbf.append("<li>");
		sbf.append(
				" <a href=/region?region=Asia>Click here To get All Countris in a region</a>");
		sbf.append("<li>");
		sbf.append(" <a href=/countriesInRegion>Click here To get Total number of countries for each region </a>");
		sbf.append("<li>");
		sbf.append(" <a href=/createCountry>Click here To Create a new countries</a>");
		sbf.append("<li>");
		sbf.append(" <a href=/deleteCountry>Click here delete any Country</a>");
		sbf.append("<li>");
		sbf.append(" <a href=/updateCountry>Click here update any Country</a>");
		sbf.append("</ul>");
		sbf.append("</body>");
		sbf.append("</html>");
		return sbf.toString();
	}

	@RequestMapping("/getAllCountries")
	public String getAllCountries() {
		StringBuffer sdf = new StringBuffer();
		List<Country> cList = new ArrayList();

		countryRepository.findAll().forEach(country -> cList.add(country));

		Map<String, Object> map = new HashMap();

		map.put("data", cList);
		sdf.append("<div class=\"container\">");
		sdf.append("<div class=\"row clearfix\">");
		sdf.append("<div class=\"col-md-12 column\">");
		sdf.append(" <a href=/>Back</a>");
		sdf.append("<table class=\"table table-bordered table-hover\" id=\"tab_logic\">");
		sdf.append("<thead>");
		sdf.append("<tr >");

		sdf.append("<th class=\"text-center\">");
		sdf.append("Id");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Country Name");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Country Capital");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Region");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Code");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Name");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Symbol");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Language");
		sdf.append("</tr>");
		sdf.append("</thead>");
		sdf.append("<tbody>");
		countryRepository.findAll().forEach(country -> {
			cList.add(country);
			sdf.append("<tr>");
			sdf.append("<td>");
			sdf.append(country.getId());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryName());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryCapital());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryRegion());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencyCode());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencyName());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencySymbol());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultLanguagesName());
			sdf.append("</td>");

			sdf.append("</tr>");
		});
		sdf.append("<tr id='addr1'></tr>");
		sdf.append("</tbody>");
		sdf.append("</table>");
		sdf.append("</div>");
		sdf.append("</div>");
		sdf.append("</div>");

		return sdf.toString();
	}

	@RequestMapping("/filterWithRegion")
	public String filterWithRegion(@RequestParam("region") String region) {
		List<Country> cList = new ArrayList();

		// countryRepository.search(region).forEach(country -> cList.add(country));
		Map<String, Object> map = new HashMap();
		StringBuffer sdf = new StringBuffer();
		sdf.append("<div class=\"container\">");
		sdf.append("<div class=\"row clearfix\">");
		sdf.append("<div class=\"col-md-12 column\">");
		sdf.append(" <a href=/>Back</a>");
		sdf.append("<table class=\"table table-bordered table-hover\" id=\"tab_logic\">");
		sdf.append("<thead>");
		sdf.append("<tr >");

		sdf.append("<th class=\"text-center\">");
		sdf.append("Id");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Country Name");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Country Capital");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Region");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Code");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Name");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Currency Symbol");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Language");
		sdf.append("</tr>");
		sdf.append("</thead>");
		sdf.append("<tbody>");
		countryRepository.search(region).forEach(country -> {
			cList.add(country);
			sdf.append("<tr>");
			sdf.append("<td>");
			sdf.append(country.getId());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryName());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryCapital());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getCountryRegion());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencyCode());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencyName());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultCurencySymbol());
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(country.getDefaultLanguagesName());
			sdf.append("</td>");

			sdf.append("</tr>");
		});
		sdf.append("<tr id='addr1'></tr>");
		sdf.append("</tbody>");
		sdf.append("</table>");
		sdf.append("</div>");
		sdf.append("</div>");
		sdf.append("</div>");

		map.put("data", cList);
		return sdf.toString();
	}

	@RequestMapping("/countriesInRegion")
	public String getCountryInRegion() {
		List<Object> cList = new ArrayList();

		countryRepository.regionCount().forEach(country -> cList.add(country));

		StringBuffer sdf = new StringBuffer();

		sdf.append("<div class=\"container\">");
		sdf.append("<div class=\"row clearfix\">");
		sdf.append("<div class=\"col-md-12 column\">");
		sdf.append(" <a href=/>Back</a>");
		sdf.append("<table class=\"table table-bordered table-hover\" id=\"tab_logic\">");
		sdf.append("<thead>");
		sdf.append("<tr >");

		sdf.append("<th class=\"text-center\">");
		sdf.append("Region");
		sdf.append("</th>");
		sdf.append("<th class=\"text-center\">");
		sdf.append("Number of Countries");
		sdf.append("</th>");

		sdf.append("</tr>");
		sdf.append("</thead>");
		sdf.append("<tbody>");
		JSONParser jsonParser = new JSONParser();
		countryRepository.regionCount().forEach(country -> {

			Object arr[] = (Object[]) country;

			cList.add(country);
			sdf.append("<tr>");
			sdf.append("<td>");
			sdf.append(arr[0]);
			sdf.append("</td>");
			sdf.append("<td>");
			sdf.append(arr[1]);
			sdf.append("</td>");

			sdf.append("</tr>");
		});
		sdf.append("<tr id='addr1'></tr>");
		sdf.append("</tbody>");
		sdf.append("</table>");
		sdf.append("</div>");
		sdf.append("</div>");
		sdf.append("</div>");

		return sdf.toString();
	}

	@RequestMapping("/createCountry")
	public String createCountry() {
		countryService.saveAllcountries();
		return "<html><body>" +

				"<form action=\"/create\" method=\"post\" modelAttribute=\"country\">" + "  <div >"
				+ "    <h1>Create Country</h1>" + "    <p>Please fill in this form to create a Country</p>" + "    <hr>"
				+

				"    <label for=\"countryName\"><b>Country Name</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Country Name\" name=\"countryName\" id=\"countryName\" required>"
				+

				"    <label for=\"countryCapital\"><b>Capital</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Country Capital\" name=\"countryCapital\" id=\"countryCapital\" required>"
				+

				"  <hr>" + "  " + "   <label for=\"countryRegion\"><b>Region</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Region\" name=\"countryRegion\" id=\"countryRegion\" required>"
				+

				"    <label for=\"defaultCurencyCode\"><b>Currency Code</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Currency Code\" name=\"defaultCurencyCode\" id=\"defaultCurencyCode\" required>"
				+

				"    <hr>" + "  " + "   <label for=\"defaultCurencyName\"><b>Currency Name</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Currency Name\" name=\"defaultCurencyName\" id=\"defaultCurencyName\" required>"
				+

				"    <label for=\"defaultCurencySymbol\"><b>Currency Symbol</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Currency Symbol\" name=\"defaultCurencySymbol\" id=\"defaultCurencySymbol\" required>"
				+

				"     <label for=\"defaultLanguagesName\"><b>Default Language Name</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter Default Language Name\" name=\"defaultLanguagesName\" id=\"defaultLanguagesName\" required>"
				+

				"  <hr>  <button type=\"submit\" >Create</button>" + "  </div>" + "  " +

				"</form>" +

				"</body>" + "</html>";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("country") Country country) {
		if (country != null) {
			country.setId(country.getCountryName() + "-" + country.getCountryCapital());
		}
		countryRepository.save(country);
		return "Congrats Country Created Success Fully \n" + country.toString();
	}

	@RequestMapping("/getCountryById")
	public Map<String, Object> getCountryById(@RequestParam("id") String id) {
		List<Country> cList = new ArrayList();

		countryRepository.findById(id);
		Map<String, Object> map = new HashMap();

		map.put("Country", countryRepository.findById(id));
		return map;
	}

	@RequestMapping("/deleteCountry")
	public String deleteCountry() {

		return "<body>" +

				"<form action=\"/deleteCountryById\">" + "  <div >" + "    <h1>Delete Country</h1>"
				+ "    <p>id ---> countryName-countryCapital</p>" + "    <hr>" + "	<div style=\"width:25%\">"
				+ "    <label for=\"countryName\"><b>Country Id</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter id to delete country\" name=\"id\" id=\"id\" required>"
				+ "	</div>" + "<hr>" + "    <button type=\"submit\" >Delete</button>" + "  </div>" +

				"</form>" +

				"</body>";
	}

	@RequestMapping("/deleteCountryById")
	public String deleteCountryById(@RequestParam("id") String id) {
		countryRepository.deleteById(id);

		return "Deleted Successfull !!!";
	}

	@RequestMapping("/updateCountry")
	public String updateCountry() {

		return "<body>" +

				"<form action=\"/updateCountryById\">" + "  <div >" + "    <h1>Update Country</h1>"
				+ "    <p>id ---> countryName-countryCapital</p>" + "    <hr>" + "	<div style=\"width:25%\">"
				+ "    <label for=\"countryName\"><b>Country Id</b></label>"
				+ "    <input type=\"text\" placeholder=\"Enter id to update/edit country\" name=\"id\" id=\"id\" required>"
				+ "	</div>" + "<hr>" + "    <button type=\"submit\" >Update</button>" + "  </div>" +

				"</form>" +

				"</body>";
	}

	@RequestMapping("/updateCountryById")
	public String updateCountryById(@RequestParam("id") String id) {
		Country ctr = countryRepository.findById(id).get();

		return "<html><body>" +

				"    <form action=\"create\" method=\"post\" modelAttribute=\"country\"><div ><h1>Update Country</h1>"
				+ "        <p>Please fill in this form to update a Country</p><hr><label for=\"countryName\"><b>Country Name</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Country Name\" name=\"countryName\" id=\"countryName\" required value=\""
				+ ctr.getCountryName() + "\">" +

				"        <label for=\"countryCapital\"><b>Capital</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Country Capital\" name=\"countryCapital\" id=\"countryCapital\" required value=\""
				+ ctr.getCountryCapital() + "\">" +

				"      <hr>" +

				"       <label for=\"countryRegion\"><b>Region</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Region\" name=\"countryRegion\" id=\"countryRegion\" required value=\""
				+ ctr.getCountryRegion() + "\">" +

				"        <label for=\"defaultCurencyCode\"><b>Currency Code</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Currency Code\" name=\"defaultCurencyCode\" id=\"defaultCurencyCode\" required value=\""
				+ ctr.getDefaultCurencyCode() + "\">" +

				"        <hr>" +

				"       <label for=\"defaultCurencyName\"><b>Currency Name</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Currency Name\" name=\"defaultCurencyName\" id=\"defaultCurencyName\" required value=\""
				+ ctr.getDefaultCurencyName() + "\">" +

				"        <label for=\"defaultCurencySymbol\"><b>Currency Symbol</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Currency Symbol\" name=\"defaultCurencySymbol\" id=\"defaultCurencySymbol\" required value=\""
				+ ctr.getDefaultCurencySymbol() + "\">" +

				"         <label for=\"defaultLanguagesName\"><b>Default Language Name</b></label>"
				+ "        <input type=\"text\" placeholder=\"Enter Default Language Name\" name=\"defaultLanguagesName\" id=\"defaultLanguagesName\" required value=\""
				+ ctr.getDefaultLanguagesName() + "\">" +

				"      <hr>  <button type=\"submit\" >update</button>" + "      </div>" +

				"    </form>" +

				"    </body>" + "    </html>";
	}

	@RequestMapping("/region")
	public String region() {
		Object[] arr = countryRepository.region().toArray();
		StringBuffer sdf = new StringBuffer();

		sdf.append("<form action=\"/filterWithRegion\">");
		sdf.append("<div>");
		sdf.append(" <h1>Select a Region and click on submit</h1>");
		sdf.append("<hr>");
		sdf.append("<div >");
		sdf.append("<label for=\"region\"><b>Region</b></label>");
		sdf.append("<select name=\"region\" id=\"region\">");
		for (int i = 0; i < arr.length; i++) {
			sdf.append("<option value=" + arr[i] + ">" + arr[i] + "</option>");
		}

		sdf.append("</select>");
		sdf.append("</div>");
		sdf.append("<hr>");
		sdf.append("<button type=\"submit\">submit</button>");
		sdf.append("</div>");

		sdf.append("</form>");

		return sdf.toString();
	}

}
