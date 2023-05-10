package com.ram.sociohub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.sociohub.entity.Comment;
import com.ram.sociohub.service.CommentService;

@RestController
@RequestMapping("/cmt")
public class CommentController {

	@Autowired
	private CommentService cmtService;
	
	@GetMapping("/cmthelo")
    @ResponseBody
    public String hello_world(){
        return "Hello World!";
    }
	
	@PostMapping("/addcmt")
	public Comment addComment(@RequestBody Comment comment) {
		comment = cmtService.addComment(comment);
		return comment;
	}
	
	@GetMapping(value="/getallcmts")
	public List<Comment> getAllUser(){
		return cmtService.getAllComment();
	}
	
	@GetMapping(value="/getcmtbyid/{id}")
	public Comment getCommentById(@PathVariable Long id) {
		return cmtService.getCommentById(id);
	}
	
	@GetMapping(value="/getcmtbyid/{name}")
	public Comment getCommentByUsername(@PathVariable String name) {
		return cmtService.getCommentByUsername(name);
	}
	   
	@GetMapping(value="/getcmtbypostid/{id}")
	public Comment getCommentByPostId(@PathVariable Long id) {
		return cmtService.getCommentByPostId(id);
	}
	
	
}
