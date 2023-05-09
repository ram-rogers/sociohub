package com.ram.sociohub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Profile;
import com.ram.sociohub.exception.ProfileNotFoundException;
import com.ram.sociohub.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {

	
	@Autowired
	ProfileRepository profileRepo;
	
	public Profile addProfile(Profile addprofile) {
		return profileRepo.save(addprofile);
	}
	
	
	public List<Profile> getAllProfile() throws ProfileNotFoundException{
		List<Profile> profileList = profileRepo.findAll();
		return profileList;
		  
	}
	
	
	public Profile getProfileById(Long id) throws ProfileNotFoundException{
		Profile profile = profileRepo.findById(id).orElse(null);
		if(profile == null) {
			throw new ProfileNotFoundException();
		}
		return profile;
	}  
	
	public Profile getUserByFullname(String fullname) throws ProfileNotFoundException{
		Profile profile = profileRepo.getProfileByFullname(fullname);
		if(profile == null) {
			throw new ProfileNotFoundException();
		}
		return profile;
	}
	
	public Profile getProfileByInstaId(String insta) throws ProfileNotFoundException{
		Profile profile = profileRepo.getProfileByInstaId(insta);
		if(profile == null) {
			throw new ProfileNotFoundException();
		}
		return profile;
	}
	
	
	public Profile getProfileByBio(String bio) throws ProfileNotFoundException{
		Profile profile = profileRepo.getProfileByBio(bio);
		if(profile == null) {
			throw new ProfileNotFoundException();
		}
		return profile;
	}
	
	
	@Transactional
	public List<Profile> deleteProfileById(Long profileId){
		profileRepo.deleteById(profileId);
		return profileRepo.findAll();
	}
	
	
	@Transactional
	public Profile updateStudentById(Long profileId, Profile updateProfile) throws ProfileNotFoundException{
		Profile existingProfile = profileRepo.findById(profileId).orElse(null);
		if(existingProfile == null) {
			throw new ProfileNotFoundException();
		}
		
		existingProfile.setBio(updateProfile.getBio());
		existingProfile.setAvatar(updateProfile.getAvatar());
		existingProfile.setDob(updateProfile.getDob());
		existingProfile.setFullname(updateProfile.getFullname());
		existingProfile.setInstaUserId(updateProfile.getInstaUserId());
		
		return profileRepo.save(existingProfile);
	}
	
	
}
