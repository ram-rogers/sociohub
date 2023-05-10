package com.ram.sociohub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.sociohub.entity.Comment;
import com.ram.sociohub.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepo;
	
	public Comment addComment(Comment comment) {
		return commentRepo.save(comment);
	}
	
	public List<Comment> getAllComment(){
		List<Comment> cmtList = commentRepo.findAll();
		return cmtList;
	}
	
	public Comment getCommentById(Long cmtId) {
		Comment cmt = commentRepo.findById(cmtId).orElse(null);
		return cmt;
	}
	
	public Comment getCommentByUsername(String userName){
		Comment cmt = commentRepo.getCommentByUsername(userName);
		return cmt;
	}
	
	public Comment getCommentByPostId(Long cmtId) {
		Comment cmt = commentRepo.getCommentByPostId(cmtId);
		return cmt;
	}
	
}
