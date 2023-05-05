package com.ram.sociohub.service;

import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Post;

import java.util.List;

@Service
public interface PostService {
    public Post create(Post Post);
    public List<Post> viewAll();
    public Post viewById(long id);
}