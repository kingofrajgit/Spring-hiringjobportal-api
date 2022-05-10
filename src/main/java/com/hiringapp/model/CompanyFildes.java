package com.hiringapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "companys_details")
public class CompanyFildes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private int  id = 0;
	
	@Column(name="mail_id")
	private String mailId = null;
	
	@Column(name="company_pass")
	private String password = null;
	
	
	
	
}
