package com.ram.sociohub.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ram.sociohub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="select u from User u where u.username=:userName")
	public User getUserByUsername(String userName);

	
	@Query(value="select * from user where email = :userEmail",nativeQuery=true)
	public List<User> getUserByEmail(String userEmail);

	@Query(value="select u from User u where u.phno=:userPhno")
	public List<User> getUserByPhno(String userPhno);


	
}
