package com.ram.sociohub.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.User;
import com.ram.sociohub.exception.UserNotFoundException;
import com.ram.sociohub.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserService {
	
	private final Logger log = LoggerFactory.getLogger(UserService.class); 

	@Autowired
	UserRepository userRepo;
	
	public User addUser(User user) {
		log.info("addUser method() starts ");
		log.info("Adding User: {}",user);
		User u = userRepo.save(user);
		log.info("User Added Successfull");
		return u;
	}   
	
	public List<User> getAllUsers(){
		log.info("getAllUsers method() starts ");
		List<User> userList = userRepo.findAll();
		log.info("Total no of Users : {}",userList.size());
		log.info("getAllusers() ends");
		return userList;
	}
	
	public User getUserById(Long userId) throws UserNotFoundException{
		log.info("getUserById method() starts ");
		User user = userRepo.findById(userId).orElse(null);
		if(user == null) {
			log.error("Error in getuserbyid");
			throw new UserNotFoundException();
		}
		log.info("The userId {} has been retrieved",userId);
		log.info("getUserById() ends");
		return user;
	}
	
	public User getUserByUsername(String userName) throws UserNotFoundException{
		log.info("getUserByUsername method() starts ");

		User user = userRepo.getUserByUsername(userName);
		if(user == null) {
			log.error("Error in getUserByUsername");

			throw new UserNotFoundException();
		}
		log.info("The username {} has been retrieved",userName);
		log.info("getUserById() ends");
		return user;
	}
	
	public List<User> getUserByEmail(String userEmail) throws UserNotFoundException {
		List<User> userList = userRepo.getUserByEmail(userEmail);
		if(userList == null) {
			log.error("Error in getUserByEmail");

			throw new UserNotFoundException();
		}
		return userList;
	}
	
	public List<User> getUserByPhno(String userPhno) throws UserNotFoundException{
		List<User> userList = userRepo.getUserByPhno(userPhno);
		if(userList == null) {
			throw new UserNotFoundException();
		}
		return userList;
	}
	
	
	@Transactional
	public List<User> deleteUserByIdAndReturnList(Long userId){
		userRepo.deleteById(userId);
		log.info("The userId {} has been deleted",userId);
		return userRepo.findAll();
	}
	
	
	@Transactional
	public User updateStudentById(Long userId, User updateUser) throws UserNotFoundException{
		log.info("updateStudentById method() starts ");
		User existingUser = userRepo.findById(userId).orElse(null);
		if(existingUser == null) {
			throw new UserNotFoundException();
		}
		
		existingUser.setUsername(updateUser.getUsername());
		existingUser.setEmail(updateUser.getEmail());
		existingUser.setPhno(updateUser.getPhno());
		existingUser.setPassword(updateUser.getPassword());
		log.info("The user has been updated.");
		log.info("updateStudentById ends");
		return userRepo.save(existingUser);
	}
	
	

	
	
}
