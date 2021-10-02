package com.card.processing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.model.UserEntity;
@Repository
public interface UserRepository  extends JpaRepository <UserEntity , Long>{
	
	@Modifying
	@Transactional
	@Query("update UserEntity s set s.active = false where s.id = :id")
	public void updateUser(@Param("id")Long id);
	
	 @Query("select cl from UserEntity cl where cl.active=true")
	    public List<UserEntity> findAllUserEntityActiveTrue();
	
	UserEntity findByusername(String userName);

	
	@Query("select count(*) from UserEntity s where s.active = true and s.username = :username")
	public int isUserExist(@Param("username")String c);
}
