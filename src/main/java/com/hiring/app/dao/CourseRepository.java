package com.hiring.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.app.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {

}
