package com.capgemini.service;

import com.capgemini.bean.Employeebean;

import com.capgemini.exception.EmployeeException;


public interface IEmployeeService {
	public int addEmployeeDetails(Employeebean employeebean) throws EmployeeException;
}
