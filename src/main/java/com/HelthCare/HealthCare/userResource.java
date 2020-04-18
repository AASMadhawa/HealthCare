package com.HelthCare.HealthCare;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.HelthCare.Model.User;
import com.HelthCare.Service.UserRepository;

@Path("/userss")
public class userResource {
	
	UserRepository ur = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAlluser() {
		return ur.getallUsers();				
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User u4) {
		return ur.createUser(u4);
	}
	
	@PUT
	@Path("/userr")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User u5) {
		
		System.out.println(u5);
		ur.updateUser(u5);
		return u5;
	}
	
}

