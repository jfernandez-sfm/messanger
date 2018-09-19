package org.samfm.jaxrs.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.samfm.jaxrs.messanger.database.DatabaseClass;
import org.samfm.jaxrs.messanger.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	public List<Profile> getProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	
	public Profile postProfile(Profile profile) {
		profile.setId((long)profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	public Profile putProfile(Profile profile) {
		if ( !profiles.containsKey(profile.getProfileName()) )
			return null;
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	public Profile deleteProfile(String profileName) {
	  return (Profile) profiles.remove(profileName);	
	}
}
