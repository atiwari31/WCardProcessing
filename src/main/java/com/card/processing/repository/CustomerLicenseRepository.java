package com.card.processing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.model.CustomerLicenseEntity;
@Repository
public interface CustomerLicenseRepository extends JpaRepository <CustomerLicenseEntity , Long>{
   @Modifying
   @Transactional
	@Query("update CustomerLicenseEntity cl set cl.active = false where cl.id = :id")
	public void deleteCustomerLicenseById(@Param("id")Long id);
    
    @Query("select cl from CustomerLicenseEntity cl where cl.active=true")
    public List<CustomerLicenseEntity> findAllCustomerLicenseActiveTrue();
    
    @Query("select cl from CustomerLicenseEntity cl where cl.user.id=:id")
    public List<CustomerLicenseEntity> findAllCustomerLicenseByUserId(@Param("id")Long id);

}
