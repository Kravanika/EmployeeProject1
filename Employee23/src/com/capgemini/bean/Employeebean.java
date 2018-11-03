package com.capgemini.bean;

import java.util.Date;

public class Employeebean {
	



	private String name;
	private String age;
	private String phoneNumber;

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}







	/*public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
*/


	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Name: " +name +"\n");
		sb.append("Age: " +age +"\n");
		sb.append("Phone Number: "+ phoneNumber +"\n");
		
	//sb.append("Reg Date: "+ regDate);
		return sb.toString();
	}
	
}
