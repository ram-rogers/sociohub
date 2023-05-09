package com.ram.sociohub.service;


import com.ram.sociohub.entity.Post;
import com.ram.sociohub.entity.User;
import com.ram.sociohub.repository.PostRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserService userService;

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }
    @Override
    public List<Post> viewAll() {
        return (List<Post>) postRepository.findAll();
    }
    @Override
    public Post viewById(long id) {
        return postRepository.findById(id).get();
    }
	@Override
	@Transactional
	public Post addImagePost(HttpServletRequest request, MultipartFile file, Long userId) throws Exception {
		byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        User user = userService.getUserById(userId);
        
        Post post = new Post();
        post.setImage(blob);
        post.setUser(user);
        return postRepository.save(post);
		
	}
	
}