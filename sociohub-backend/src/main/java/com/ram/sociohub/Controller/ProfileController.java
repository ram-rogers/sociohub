package com.ram.sociohub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.sociohub.entity.Profile;
import com.ram.sociohub.exception.ProfileNotFoundException;
import com.ram.sociohub.exception.UserNotFoundException;
import com.ram.sociohub.repository.ProfileRepository;
import com.ram.sociohub.service.ProfileService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProfileController {

	
	
	private ProfileService profileService;
	
	@Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
	

	@GetMapping("/profile/hello")
    @ResponseBody
    public String hello_world(){
        return "Hello Profile!";
    }
	
	
	@PostMapping("/addprofile")
	public Profile newProfile(@RequestBody Profile profile) {
		profile = profileService.addProfile(profile);
		return profile;
	}
	   
	@GetMapping(value="/getallprofile")
	public List<Profile> getAllProfile(){
		return profileService.getAllProfile();
	}
	
	@GetMapping(value="/getprofilebyid/{id}")
	public Profile getProfileById(@PathVariable Long id) throws ProfileNotFoundException{
		return profileService.getProfileById(id);
	}
	
	@GetMapping(value="/getprofilebybio/{id}")
	public Profile getProfileByBio(@PathVariable String bio) throws ProfileNotFoundException{
		return profileService.getProfileByBio(bio);
	}
	
	
	
	  
	@PutMapping("/updateprofilebyid/{id}")
	public ResponseEntity<Profile> updateProfileById(@PathVariable("id") Long profileId,@RequestBody Profile updatedProfile) throws UserNotFoundException{
		Profile profile = profileService.updateStudentById(profileId, updatedProfile);
		return ResponseEntity.ok(profile);
	}
	
	
	@DeleteMapping("/deleteprofilerbyid/{id}")
	public List<Profile> deleteProfileById(@PathVariable("id") Long id) {
		List<Profile> profile = profileService.deleteProfileById(id);
		return profile;
	}
	
	
}
