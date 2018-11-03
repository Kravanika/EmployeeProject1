package com.capgemini.service;

import com.capgemini.dao.EmployeeDaoImpl;


import com.capgemini.dao.IEmployeeDAO;

import com.capgemini.exception.EmployeeException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.Employeebean;

public  class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeDAO employeeDao;
	
	public int addEmployeeDetails(Employeebean employeebean) throws EmployeeException {
		
		employeeDao= new EmployeeDaoImpl();
		int employee_Id_sequence;
		employee_Id_sequence= employeeDao.addEmployeeDetails(employeebean);
		return employee_Id_sequence;
	}
	
	
		public void validateEmployee(Employeebean bean) throws Exception
		{
			List<String> validationErrors = new ArrayList<String>();

			//Validating name
			if(!(isValidName(bean.getName()))) {
				validationErrors.add("\n Patient Name Should Be In Alphabets and minimum 3 characters long ! \n");
			}
			/*//Validating age
			if(!(isValidAge(bean.getAge()))){
				validationErrors.add("\n Age Should Be Entered \n");
			}*/
			//Validating Phone Number
			if(!(isValidPhoneNumber(bean.getPhoneNumber()))){
				validationErrors.add("\n Phone Number Should be in 10 digit \n");
			}
			
		
			if(!validationErrors.isEmpty())
				throw new EmployeeException(validationErrors +"");
		}

		public boolean isValidName(String name){
			Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher=namePattern.matcher(name);
			return nameMatcher.matches();
		}
		/*public boolean isValidAge(String age){
			return (age.length()>3);
		}*/
		
		public boolean isValidPhoneNumber(String phoneNumber){
			Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
			Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
			return phoneMatcher.matches();
			
		}
		
		public boolean validateEmployeeId(String employee_id) {
			
			Pattern idPattern = Pattern.compile("[0-9]{1,4}");
			Matcher idMatcher = idPattern.matcher(employee_id);
			
			if(idMatcher.matches())
				return true;
			else
				return false;		
		}
}


		
