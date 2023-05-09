package com.ram.sociohub.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ram.sociohub.entity.Post;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

@Service
public interface PostService {
    public Post create(Post Post);
    public List<Post> viewAll();
    public Post viewById(long id);
	public Post addImagePost(HttpServletRequest request, MultipartFile file, Long userId) throws Exception;
}