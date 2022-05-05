package com.hiring.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.app.model.CompanyFildes;


@Repository
public interface CompanyRepository extends JpaRepository<CompanyFildes, Integer> {

}
