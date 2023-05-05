package com.ram.sociohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.sociohub.entity.Post;

@Repository
public interface ImageRepository extends JpaRepository<Post, Integer>{

}
