package com.hiringJobPortal.hiringJobportalapi.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hiringJobPortal.hiringJobportalapi.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Application u set u.vacancy=:vacancy , u.salary=:salary where u.jobId=:id")
	int updateByVancancyAndSalaryAndFinalDate(@Param("id")int id,@Param("vacancy") int vacancy,@Param("salary") int salary) throws SQLException;
	
	@Query("select u from Application u where u.lastDate>:localDate")
	List<Application> findByLastDate(@Param("localDate")LocalDate localDate);
	
//	@Transactional
//	@Modifying
//	@Query("update Application u set u.vacancy=:obj.vacancy , u.salary=:obj.salary where u.jobId=:id")
//	void updateByVancancyAndSalaryAndFinalDate(@Param("id")int id, ) ;
	
}
