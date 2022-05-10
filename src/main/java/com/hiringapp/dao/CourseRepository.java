package com.hiringapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringapp.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {

}
