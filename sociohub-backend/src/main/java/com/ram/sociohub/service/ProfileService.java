package com.ram.sociohub.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Profile;
import com.ram.sociohub.exception.ProfileNotFoundException;
import com.ram.sociohub.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {

	private final Logger log = LoggerFactory.getLogger(UserService.class); 

	@Autowired
	ProfileRepository profileRepo;  
	
	public Profile addProfile(Profile addprofile) {
		log.info("addProfile method() starts ");
		log.info("The Profile {} has been added.",addprofile);
		log.info("addProfile method() ends ");
		return profileRepo.save(addprofile);
	}
	
	
	public List<Profile> getAllProfile() throws ProfileNotFoundException{
		log.info("getAllProfile method() starts ");
		List<Profile> profileList = profileRepo.findAll();
		log.info("The Profiles has been retrieved from the database");
		log.info("getAllProfile method() ends ");
		return profileList;
		  
	}
	
	
	public Profile getProfileById(Long id) throws ProfileNotFoundException{
		log.info("getProfileById method() starts ");
		Profile profile = profileRepo.findById(id).orElse(null);
		if(profile == null) {
			throw new ProfileNotFoundException();
		}
		log.info("The Profile {} has been retrieved .",id);
		log.info("getProfileById method() ends ");
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
		log.info("deleteProfileById method() starts ");
		profileRepo.deleteById(profileId);
		log.info("The Profile {} has been deleted.",profileId);
		log.info("deleteProfileById method() ends ");
		return profileRepo.findAll();
	}
	
	
	@Transactional
	public Profile updateStudentById(Long profileId, Profile updateProfile) throws ProfileNotFoundException{
		log.info("updateStudentById method() starts ");
		
		Profile existingProfile = profileRepo.findById(profileId).orElse(null);
		if(existingProfile == null) {
			throw new ProfileNotFoundException();
		}
		
		existingProfile.setBio(updateProfile.getBio());
		existingProfile.setAvatar(updateProfile.getAvatar());
		existingProfile.setDob(updateProfile.getDob());
		existingProfile.setFullname(updateProfile.getFullname());
		existingProfile.setInstaUserId(updateProfile.getInstaUserId());
		log.info("The Profile {} has been updated.",updateProfile);
		log.info("updateStudentById method() ends ");
		return profileRepo.save(existingProfile);
	}
	
	
}
