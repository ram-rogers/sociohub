package com.ram.sociohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ram.sociohub.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	@Query(value="select * from comment where username=:username",nativeQuery = true)
	public Comment getCommentByUsername(String username);
	
	@Query(value="select * from comment where pid=:pid",nativeQuery = true)
	public Comment getCommentByPostId(Long pid);
	
	  
}
