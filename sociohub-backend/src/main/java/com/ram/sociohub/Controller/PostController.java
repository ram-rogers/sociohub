package com.ram.sociohub.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ram.sociohub.entity.Post;
import com.ram.sociohub.repository.PostRepository;
import com.ram.sociohub.service.PostServce;
import com.ram.sociohub.service.PostService;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostServce postServce;
	
	@Autowired
	private PostRepository postrepo;
	
	@GetMapping("/getimgs")
	List<Post> getAllUsers(){
		return postrepo.findAll();
	}
	
	@PostMapping("/uploadpost")
    public String uploadImage(@RequestParam("image") MultipartFile file,@RequestParam("desc") String desc
    ) {
		postServce.uploadImage(file, desc);
        return "Post success";
    }
	
	
	
	
	
}
