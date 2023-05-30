package com.ram.sociohub.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ram.sociohub.entity.Post;
import com.ram.sociohub.exception.PostException;
import com.ram.sociohub.repository.PostRepository;

@Service
public class PostServiceImpl implements PostServce {
	
	private static final String UPLOAD_DIR = "C://springimg/";
	
	private final Logger log = LoggerFactory.getLogger(UserService.class); 
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public void uploadImage(MultipartFile file, String desc) {
		
		if (!file.isEmpty()) {
            try {
                // Generate a unique filename for the image
                String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

                // Create a new instance of your image model/entity
                Post post = new Post();
                post.setImage(fileName);
				post.setDescription(desc);
				log.info("uploadPost method() starts ");

				Date date = new Date();
				long time = date.getTime();
				Timestamp dateTime = new Timestamp(time);
				
				
				post.setDateTime(dateTime);       
				post.setLikes(0);

                // Save the image file to disk
                String filePath = UPLOAD_DIR + fileName;
                file.transferTo(new File(filePath));

                // Save the image details to the database
                postRepo.save(post);
            } catch (IOException e) {
                throw new PostException("Failed to upload image", e);
            }
        } else {
            throw new PostException("No file selected");
        }
		
		
	}

}
