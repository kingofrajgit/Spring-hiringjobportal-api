package com.hiringJobPortal.hiringJobportalapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringJobPortal.hiringJobportalapi.model.AppliedApplication;

@Repository
public interface AppliedApplicationRepository extends JpaRepository<AppliedApplication, Integer>{

}