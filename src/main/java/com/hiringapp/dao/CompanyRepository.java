package com.hiringapp.dao;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.hiringapp.model.CompanyFildes;


@Repository
public interface CompanyRepository extends JpaRepository<CompanyFildes, Integer> {

	CompanyFildes findByMailId(String mailId);
	
	@Transactional
	@Modifying
	@Query("update CompanyFildes c set c.password=:password where c.mailId=:mailId")
	int forgetPassword(@Param("password")String password,@Param("mailId") String mailId)throws SQLException;

}
