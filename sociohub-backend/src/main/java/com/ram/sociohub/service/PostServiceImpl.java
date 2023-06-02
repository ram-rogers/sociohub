package com.ram.sociohub.service;


import java.sql.Timestamp;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Post;
import com.ram.sociohub.repository.PostRepository;

@Service
public class PostServiceImpl implements PostServce {

	private final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private PostRepository postRepo;

	@Override
	public void uploadImage(String owner, String desc) {

		// Create a new instance of your image model/entity
		Post post = new Post();
		post.setOwner(owner);
		post.setDescription(desc);
		log.info("uploadPost method() starts ");

		Date date = new Date();
		long time = date.getTime();
		Timestamp dateTime = new Timestamp(time);

		post.setDateTime(dateTime);
		post.setLikes(0);

		postRepo.save(post);
	}

}
