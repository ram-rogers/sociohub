package com.ram.sociohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.sociohub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
