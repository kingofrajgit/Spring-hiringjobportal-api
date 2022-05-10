package com.hiringapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringapp.model.AppliedApplication;

@Repository
public interface AppliedApplicationRepository extends JpaRepository<AppliedApplication, Integer>{

	List<AppliedApplication> findByMailId(String emailId);

}
