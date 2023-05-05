package com.ram.sociohub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.sociohub.entity.Profile;
import com.ram.sociohub.exception.UserNotFoundException;
import com.ram.sociohub.repository.ProfileRepository;

@RestController
public class ProfileController {

	
	@Autowired
	private ProfileRepository profileRepo;
	
	@GetMapping("/profile/hello")
    @ResponseBody
    public String hello_world(){
        return "Hello Profile!";
    }
	
	@PostMapping("/postprofile")
	Profile newProfile(@RequestBody Profile newProfile) {
		return profileRepo.save(newProfile);
	}
	
	
	
	@GetMapping("/getprofile")
	List<Profile> getAllUsers(){
		return profileRepo.findAll();
	}
	
	@GetMapping("/getprofile/{id}")
	Profile getProfileById(@PathVariable Long id) {
		return profileRepo.findById(id).orElseThrow(()->new UserNotFoundException());
	}  
	
	
	@PutMapping("/postprofile/{id}")
	Profile updateProfile(@RequestBody Profile newProfile,@PathVariable Long id) {
		return profileRepo.findById(id)
				.map(profile -> {
					profile.setBio(newProfile.getBio());
					profile.setAvatar(newProfile.getAvatar());
					profile.setFullname(newProfile.getFullname());
					profile.setDob(newProfile.getDob());
					profile.setInstaUserId(newProfile.getInstaUserId());
					
					return profileRepo.save(profile);
				}).orElseThrow(()->new UserNotFoundException());
	}
	
	
	@DeleteMapping("/deleteprofile/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!profileRepo.existsById(id)) {
			throw new UserNotFoundException();
		}
		profileRepo.deleteById(id);
		return "User With id "+ id +" has been deleted"; 
	}
	
	
}
