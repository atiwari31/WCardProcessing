package com.card.processing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.model.UserProfileEntity;

@Repository
public interface UserProfileRepository extends JpaRepository <UserProfileEntity , Long>{
    
	@Modifying
	@Transactional
	@Query("update UserProfileEntity up set up.active = false where up.id = :id")
	public void updateProfile(@Param("id")Long id);
    
	@Query("select up from UserProfileEntity up where up.active=true")
	public List<UserProfileEntity> findAllUserProfileactivrTrue();

}
