package com.xworkz.customerinsights.dto;

import java.util.Arrays;

public class CustomerInsightsDto {
	
	
	
 
	private String firstName;
    
	private String lastName;
   
	private String email;
    
	private String password;
  
	private String confirmPassword;
  
	private String dateOfBirth;
    
	private String gender;
	
	public CustomerInsightsDto() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public CustomerInsightsDto(String firstName, String lastName, String email, String password, String confirmPassword,
			String dateOfBirth, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerInsightsDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}

	
	

}
