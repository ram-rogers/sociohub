package com.ram.sociohub.service;

import org.springframework.web.multipart.MultipartFile;

public interface PostServce {
	void uploadImage(MultipartFile file, String title);
}
