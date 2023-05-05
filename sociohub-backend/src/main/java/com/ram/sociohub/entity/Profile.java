package com.ram.sociohub.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Profile {
	@Id
	@GeneratedValue
	private Long id;
	private String bio;
	private String avatar;
	private String fullname;
	private String dob;
	private String instaUserId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getInstaUserId() {
		return instaUserId;
	}
	public void setInstaUserId(String instaUserId) {
		this.instaUserId = instaUserId;
	}
	
	
	
	
}
