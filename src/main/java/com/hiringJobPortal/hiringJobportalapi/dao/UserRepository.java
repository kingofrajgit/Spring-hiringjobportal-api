package com.hiringJobPortal.hiringJobportalapi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hiringJobPortal.hiringJobportalapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Transactional
	@Modifying
	@Query("update User u set u.userPass=:password where u.userMailId=:mailId")
	int forgetPassword(@Param("password")String password,@Param("mailId") String mailId)throws SQLException;
	
	
	

}
