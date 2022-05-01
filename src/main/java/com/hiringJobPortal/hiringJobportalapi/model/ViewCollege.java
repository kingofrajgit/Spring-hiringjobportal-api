package com.hiringJobPortal.hiringJobportalapi.model;


import javax.persistence.Entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="college_names")
public class ViewCollege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(name="key_name")
	private String keyName = null;
	
	@Column(name="college")
	private String college = null;


}
