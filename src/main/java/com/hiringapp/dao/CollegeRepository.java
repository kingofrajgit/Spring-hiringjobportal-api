package com.hiringapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringapp.model.ViewCollege;

@Repository
public interface CollegeRepository extends JpaRepository<ViewCollege, Integer> {

	
}
