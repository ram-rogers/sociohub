package com.ram.sociohub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.User;
import com.ram.sociohub.exception.UserNotFoundException;
import com.ram.sociohub.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> userList = userRepo.findAll();
		return userList;
	}
	
	public User getUserById(Long userId) throws UserNotFoundException{
		User user = userRepo.findById(userId).orElse(null);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}
	
	public User getUserByUsername(String userName) throws UserNotFoundException{
		User user = userRepo.getUserByUsername(userName);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}
	
	public List<User> getUserByEmail(String userEmail) throws UserNotFoundException {
		List<User> userList = userRepo.getUserByEmail(userEmail);
		if(userList == null) {
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
		return userRepo.findAll();
	}
	
	
	@Transactional
	public User updateStudentById(Long userId, User updateUser) throws UserNotFoundException{
		User existingUser = userRepo.findById(userId).orElse(null);
		if(existingUser == null) {
			throw new UserNotFoundException();
		}
		
		existingUser.setUsername(updateUser.getUsername());
		existingUser.setEmail(updateUser.getEmail());
		existingUser.setPhno(updateUser.getPhno());
		existingUser.setPassword(updateUser.getPassword());
		
		return userRepo.save(existingUser);
	}
	
	
	
	
	
	
	
	
}
