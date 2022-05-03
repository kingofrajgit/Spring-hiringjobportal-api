package com.hiring.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.app.model.AppliedApplication;

@Repository
public interface AppliedApplicationRepository extends JpaRepository<AppliedApplication, Integer>{

}
