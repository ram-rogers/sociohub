package com.ram.sociohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.sociohub.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
