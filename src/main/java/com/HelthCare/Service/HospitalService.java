package com.HelthCare.Service;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import com.HelthCare.Model.Hospital;

@Path("/hospital")
public class HospitalService {
	
	Hospital hosObj = new Hospital();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return hosObj.readHospitals();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(
			@FormParam("hospitalID") String hospitalID, 
			@FormParam("hospitalName") String hospitalName,
			@FormParam("hospitalAddress") String hospitalAddress, 
			@FormParam("hospitalDesc") String hospitalDesc,
			@FormParam("hospitalContact") String hospitalContact) {

		String output = hosObj.insertHospital(hospitalID, hospitalName, hospitalAddress, hospitalDesc, hospitalContact);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {

		// Convert the input string to a JSON object
		JsonObject hosObject = new JsonParser().parse(hospitalData).getAsJsonObject();

		// Read the values from the JSON object
		String id = hosObject.get("id").getAsString();
		String hospitalID = hosObject.get("hospitalID").getAsString();
		String hospitalName = hosObject.get("hospitalName").getAsString();
		String hospitalAddress = hosObject.get("hospitalAddress").getAsString();
		String hospitalDesc = hosObject.get("hospitalDesc").getAsString();
		String hospitalContact = hosObject.get("hospitalContact").getAsString();
		
		String output = hosObj.updateHospital(id, hospitalID, hospitalName, hospitalAddress, hospitalDesc,hospitalContact);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String id = doc.select("id").text();
		String output = hosObj.deleteHospital(id);
		return output;
	}
	
}

