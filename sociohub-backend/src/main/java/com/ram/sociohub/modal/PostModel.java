package com.ram.sociohub.modal;

import java.sql.Blob;
import java.util.Date;

import com.ram.sociohub.entity.User;

public class PostModel {
	private Integer postId;
	private Long uid;
	private Blob image;
	private Date date = new Date();
	
	
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "PostModel [postId=" + postId + ", uid=" + uid + ", image=" + image + ", date=" + date + "]";
	}
	
	
}
