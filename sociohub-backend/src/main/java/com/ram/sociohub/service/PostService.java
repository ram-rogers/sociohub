package com.ram.sociohub.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ram.sociohub.entity.Post;
import com.ram.sociohub.entity.User;
import com.ram.sociohub.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	private final Logger log = LoggerFactory.getLogger(UserService.class); 

	
//	User user = new User();
	
//	public Post uploadPost(Post post){
//		log.info("uploadPost method() starts ");
//
//		Date date = new Date();
//		long time = date.getTime();
//		Timestamp dateTime = new Timestamp(time);
//		
//		
//		post.setDateTime(dateTime);
//		post.setLikes(0);
//		
//		log.info("The Post has been uploaded to the database");
//		log.info("uploadPost method() ends ");
//		return postRepository.save(post);		
//	}
	
	public Post uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("title") String desc) {
		
		if(!file.isEmpty()) {
			try {
				String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
				
				Post post = new Post();
				
				post.setImage(fileName);
				post.setDescription(desc);
				log.info("uploadPost method() starts ");

				Date date = new Date();
				long time = date.getTime();
				Timestamp dateTime = new Timestamp(time);
				
				
				post.setDateTime(dateTime);       
				post.setLikes(0);
				
				log.info("The Post has been uploaded to the database");
				log.info("uploadPost method() ends ");
				
				
				
				
				String filePath = "C://springimg/" + fileName;
				file.transferTo(new File(filePath));
				
				return postRepository.save(post);
//				return "Image Upload success";
			}
			catch (IOException e) {
                e.printStackTrace();
//                return "Upload failed";
            }
			
		}
//		return "No file selected";
		return null;
		
	}
	
	public List<Post> getAllPosts(){
		log.info("getAllPosts method() starts ");
		List<Post> postList = postRepository.findAll();
		log.info("The datas has been retrieved from the database");
		log.info("getAllPosts() ends");
		return postList;
	}
	
	public Post getPostById(Long postId) throws Exception{
		Post post = postRepository.findById(postId).orElse(null);
		return post;
	}

	
	@Transactional
	public List<Post> deletePostByIdAndReturnList(Long postId){
		log.info("deletePostByIdAndReturnList method() starts ");
		postRepository.deleteById(postId);
		log.info("The post {} has been deleted",postId);
		log.info("deletePostByIdAndReturnList method() ends ");

		return postRepository.findAll();
	}
	  
	
}