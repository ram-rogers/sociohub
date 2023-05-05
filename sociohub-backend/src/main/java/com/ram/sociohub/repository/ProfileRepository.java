package com.ram.sociohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ram.sociohub.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	
	@Query(value="select * from profile where fullname=:fullname",nativeQuery = true)
	public Profile getProfileByFullname(String fullname);
	
	@Query(value="select * from profile where insta_user_id=:insta",nativeQuery = true)
	public Profile getProfileByInstaId(String insta);
	
	@Query(value="select * from profile where bio=:bio",nativeQuery = true)
	public Profile getProfileByBio(String bio);
	
}
