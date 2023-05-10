package com.ram.sociohub.entity;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;
	
	
	
	private String image;
	private String description;
	private int likes;
	private Timestamp dateTime;
	
	
	       
	
}
