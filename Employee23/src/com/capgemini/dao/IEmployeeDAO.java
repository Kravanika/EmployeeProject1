package com.capgemini.dao;
import com.capgemini.bean.Employeebean;



import com.capgemini.exception.EmployeeException;
public interface IEmployeeDAO {
	public int addEmployeeDetails(Employeebean employeebean) throws EmployeeException;
}





