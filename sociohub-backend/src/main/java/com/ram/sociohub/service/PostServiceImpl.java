package com.ram.sociohub.service;


import com.ram.sociohub.entity.Post;
import com.ram.sociohub.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

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
	
}