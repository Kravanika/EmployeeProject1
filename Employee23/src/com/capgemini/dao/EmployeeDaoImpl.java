package com.capgemini.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.bean.Employeebean;
import com.capgemini.exception.EmployeeException;
import com.capgemini.util.DBConnection;

public class EmployeeDaoImpl implements IEmployeeDAO {
	
	Logger logger=Logger.getRootLogger();
	
	public EmployeeDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	@SuppressWarnings("resource")
	public int addEmployeeDetails(Employeebean employeebean) throws EmployeeException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		int employee_id=0;
		
		int queryResult=0;
		try
		{	
			
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			
			preparedStatement.setString(1, employeebean.getName());
			preparedStatement.setString(2, employeebean.getAge());
			preparedStatement.setString(3, employeebean.getPhoneNumber());
		
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.EMPLOYEEID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				employee_id=resultSet.getInt(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new EmployeeException("Inserting Employee details failed ");

			}
			else
			{
				logger.info("Employee details added successfully:");
				return employee_id;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new EmployeeException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new EmployeeException("Error in closing db connection");

			}
		}
		
		
	}

	

}
