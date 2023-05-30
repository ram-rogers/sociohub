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

import com.ram.sociohub.entity.User;
import com.ram.sociohub.exception.UserNotFoundException;
import com.ram.sociohub.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
  
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
    @ResponseBody
    public String hello_world(){
        return "Hello World!";
    }
	
	@GetMapping(value="/getallusers")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/getuserbyid/{id}")
	public User getUserById(@PathVariable Long id) throws UserNotFoundException{
		return userService.getUserById(id);
	}
	
	@GetMapping(value="/getuserbyusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username) throws UserNotFoundException{
		return userService.getUserByUsername(username);
	}
	
	@GetMapping(value="/getuserbyemail/{email}")
	public List<User> getUserByEmail(@PathVariable("email") String email) throws UserNotFoundException{
		return userService.getUserByEmail(email);
	}
	
	@GetMapping(value="/getuserbyphno/{phno}")
	public List<User> getUserByPhno(@PathVariable("phno") String phno) throws UserNotFoundException{
		return userService.getUserByPhno(phno);
	}
	
	@PostMapping("/adduser")
	public User newUser(@RequestBody User user) {
		user = userService.addUser(user);
		return user;
	}
	
	
	@DeleteMapping("/deleteuserbyid/{id}")
	public List<User> deleteUserById(@PathVariable("id") Long id) {
		List<User> users = userService.deleteUserByIdAndReturnList(id);
		return users;
	}
	
	
	@PutMapping("/updateuserbyid/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") Long userId,@RequestBody User updatedUser) throws UserNotFoundException{
		User user = userService.updateStudentById(userId, updatedUser);
		return ResponseEntity.ok(user);
	}
	
	
	
	
	
	
	
	
	
	
	
}
