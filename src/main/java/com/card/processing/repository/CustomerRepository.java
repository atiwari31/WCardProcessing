package com.card.processing.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.model.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity , Long>{

	//@Query("UPDATE CustomerEntity SET active = 'false' where id =:id")
	@Modifying
	@Transactional
	@Query("update CustomerEntity s set s.active = false where s.id = :id")
	public void upadteCustomer(@Param("id")Long id);
    
	@Query("select c from CustomerEntity c where c.active=true")
	public List<CustomerEntity> findAllCustomerActiveTrue();
	
	@Query("select count(*) from CustomerEntity s where s.active = true and s.email = :email and s.mobile = :mobile")
	public int isUserExist(@Param("email")String email,@Param("mobile") BigInteger mobile);
	
	@Query("select c from CustomerEntity c where c.user.id=:id")
	public List<CustomerEntity> findAllCustomerByUserId(@Param("id")Long id);
	
}
