package com.company.yedam.emp.dao;

import lombok.Data;

@Data
public class JobVO {
	String job_id; 
	String job_title; 
	int min_salary;    
	int max_salary;    
}
