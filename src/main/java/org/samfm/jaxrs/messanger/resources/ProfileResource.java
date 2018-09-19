package org.samfm.jaxrs.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.samfm.jaxrs.messanger.model.Profile;
import org.samfm.jaxrs.messanger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService ps = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return ps.getProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return ps.getProfile(profileName);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile postProfile(Profile profile) {
		return ps.postProfile(profile);
	}
	
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile putProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return ps.putProfile(profile);
	}
	
	
	@DELETE
	@Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
	public Profile deleteProfile(@PathParam("profileName") String profileName) {
		return ps.deleteProfile(profileName);
	}
}
