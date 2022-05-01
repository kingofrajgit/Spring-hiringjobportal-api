package com.hiringJobPortal.hiringJobportalapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringJobPortal.hiringJobportalapi.model.ViewCollege;

@Repository
public interface CollegeRepository extends JpaRepository<ViewCollege, Integer> {

	
}
