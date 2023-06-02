package com.ram.sociohub.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ram.sociohub.entity.Post;
import com.ram.sociohub.repository.PostRepository;
import com.ram.sociohub.service.PostServce;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostServce postServce;
	
	@Autowired
	private PostRepository postrepo;
	
	@GetMapping("/getpost")
	List<Post> getAllUsers(){
		Sort sort = Sort.by(Sort.Direction.DESC, "postId");
        return postrepo.findAll(sort);
//		return postrepo.findAll();
	}
	
	@PostMapping("/uploadpost")
    public String uploadImage(@RequestParam("owner") String owner,@RequestParam("desc") String desc) {
		postServce.uploadImage(owner, desc);
        return "Post success";
    }
	
	
	
	
	
}
