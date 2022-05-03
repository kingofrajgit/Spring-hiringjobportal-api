package com.hiring.app.dao;

import java.sql.SQLException;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hiring.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Transactional
	@Modifying
	@Query("update User u set u.userPass=:password where u.userMailId=:mailId")
	int forgetPassword(@Param("password")String password,@Param("mailId") String mailId)throws SQLException;
	
	
	

}
