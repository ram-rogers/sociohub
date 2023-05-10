package com.ram.sociohub.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Post uploadPost(Post post){
		log.info("uploadPost method() starts ");

		Date date = new Date();
		long time = date.getTime();
		Timestamp dateTime = new Timestamp(time);
		
		
		post.setDateTime(dateTime);
		post.setLikes(0);
		
		log.info("The Post has been uploaded to the database");
		log.info("uploadPost method() ends ");
		return postRepository.save(post);		
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