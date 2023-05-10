package com.ram.sociohub.Controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ram.sociohub.entity.Post;
import com.ram.sociohub.entity.User;
import com.ram.sociohub.service.PostService;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/ping")
    @ResponseBody
    public String hello_world(){
        return "Hello World";
    }
    
           
    @PostMapping("/addimg")
    public Post newPost(@RequestBody Post post) {
    	post = postService.uploadPost(post);
    	return post;
    }
    
    @GetMapping(value="/getallpost")
	public List<Post> getAllUser(){
		return postService.getAllPosts();
	}
    
    
    @GetMapping(value="/getpostbyid/{id}")
	public Post getUserById(@PathVariable Long id) throws Exception{
		return postService.getPostById(id);
	}
    
    @DeleteMapping("/deleteuserbyid/{id}")
	public List<Post> deletePostById(@PathVariable("id") Long id) {
		List<Post> post = postService.deletePostByIdAndReturnList(id);
		return post;
	}
    
    
}