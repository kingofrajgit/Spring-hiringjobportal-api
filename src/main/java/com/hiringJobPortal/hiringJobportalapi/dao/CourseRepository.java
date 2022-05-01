package com.hiringJobPortal.hiringJobportalapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringJobPortal.hiringJobportalapi.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {

}
