package com.ram.sociohub.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	private String comment;
	private Timestamp timestamp;
	
//	@ManyToOne
//	@JoinColumn(name="uid")
//	private User user;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Post post;
	   
	
}



