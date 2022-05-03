package com.hiring.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.app.model.ViewCollege;

@Repository
public interface CollegeRepository extends JpaRepository<ViewCollege, Integer> {

	
}
