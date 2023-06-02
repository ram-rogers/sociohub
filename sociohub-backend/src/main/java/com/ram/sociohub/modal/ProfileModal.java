package com.ram.sociohub.modal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProfileModal {
	
	private Long id;
	
	private String bio;
	private String avatar;
	private String fullname;

	private String about;
	private String city;
	private String instaUserId;
	
	
	private Long userId;

}
