package com.ram.sociohub.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Profile;
import com.ram.sociohub.exception.ProfileNotFoundException;
import com.ram.sociohub.modal.ProfileModal;
import com.ram.sociohub.repository.ProfileRepository;
import com.ram.sociohub.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {

	private final Logger log = LoggerFactory.getLogger(UserService.class); 
	

	@Autowired
	public ProfileRepository profileRepo;  
	  
	@Autowired
	public UserRepository userRepo;
	

	
	
	
	public ProfileModal addProfile(Profile addprofile) {
		log.info("addProfile method() starts ");
		log.info("addProfile method() ends ");
		Profile pro = profileRepo.save(addprofile);
		log.info("The Profile {} has been added.",addprofile);
		ProfileModal proModal = new ProfileModal();
		proModal.setId(pro.getId());
		proModal.setFullname(pro.getFullname());
		proModal.setAbout(pro.getAbout());
		proModal.setBio(pro.getBio());
		proModal.setCity(pro.getCity());
		proModal.setInstaUserId(pro.getInstaUserId());
//		proModal.setUserId(pro.getUser().getId());

		return proModal;
		
		  
	}
	
	
	
	
//	public ProfileModal addProfile(String fullname,String bio,String about,String city,String insta,String user_id) throws IllegalStateException, IOException {
//		
//			long uid=Long.parseLong(user_id);  
//			System.err.println(uid);
//			
//		
//            // Generate a unique filename for the image
//
//            Profile pro = new Profile();
//            
//            ProfileModal profile = new ProfileModal();
//            profile.setAbout(about);
//            profile.setBio(bio);
//            profile.setUserId(uid);
//       
//            profile.setFullname(fullname);
//            profile.setCity(city);
//            
//			log.info("uploadPost method() starts ");
//
//
//            profileRepo.save(profile);
//			return profile;
//         
//		
//		
//	}
	
	
	public List<Profile> getAllProfile() throws ProfileNotFoundException{
		log.info("getAllProfile method() starts ");
		List<Profile> profileList = profileRepo.findAll();
		log.info("The Profiles has been retrieved from the database");
		log.info("getAllProfile method() ends ");
		return profileList;
		  
	}
	
	public List<Profile> getProfileByUserId(Long userId){
		return profileRepo.findByUserId(userId);
		
	}   
	
	
	public ProfileModal getProfileById(Long id) throws ProfileNotFoundException{
		log.info("getProfileById method() starts ");
		Profile pro = profileRepo.findById(id).orElse(null);
		if(pro == null) {
			throw new ProfileNotFoundException();
		}
		log.info("The Profile {} has been retrieved .",id);
		log.info("getProfileById method() ends ");
		ProfileModal proModal = new ProfileModal();
		proModal.setId(pro.getId());
		proModal.setFullname(pro.getFullname());
		proModal.setAbout(pro.getAbout());
		proModal.setBio(pro.getBio());
		proModal.setCity(pro.getCity());
		proModal.setInstaUserId(pro.getInstaUserId());
		proModal.setUserId(pro.getUser().getId());
		return proModal;
		
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
		existingProfile.setFullname(updateProfile.getFullname());
		existingProfile.setInstaUserId(updateProfile.getInstaUserId());
		log.info("The Profile {} has been updated.",updateProfile);
		log.info("updateStudentById method() ends ");
		return profileRepo.save(existingProfile);
	}
	
	
}
