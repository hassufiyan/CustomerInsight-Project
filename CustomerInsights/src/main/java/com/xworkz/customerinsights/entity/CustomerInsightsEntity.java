package com.xworkz.customerinsights.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity

public class CustomerInsightsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	
	@NotBlank(message="id should not be blank")
	@Column(name="ID")
	private int id;
	
	@NotBlank(message="firstName should not be blank")
	@Column(name="firstName")
	private String fristName;
	
	@NotBlank(message="lastName should not be blank")
	@Column(name="lastName")
	private String lastName;
	
	@Email(message="email is not valid") 
	@Column(name="email")
	private String email;
	
	@Min(value = 8) @Max(value=15)
	@Column(name="password")
	private String password;
	
	@Min(value = 8) @Max(value=15)
	@Column(name="confirmPassword")
	private String confirmPassword;
	
	@Column(name="dateOfBirth")
	private String dateOfBirth;
	
	@NotBlank(message="gender filed cant be balnk")
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="ceatedBy")
	private String createdBy;
	
	@Column(name="createdOn")
	private LocalTime createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private String UpdatedOn;
	
	
	public CustomerInsightsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerInsightsEntity(String fristName, String lastName, String email, String password,
			String confirmPassword, String dateOfBirth, String gender, String createdBy, LocalTime createdOn,
			String updatedBy, String updatedOn) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		UpdatedOn = updatedOn;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
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


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public LocalTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalTime localTime) {
		this.createdOn = localTime;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getUpdatedOn() {
		return UpdatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		UpdatedOn = updatedOn;
	}


	@Override
	public String toString() {
		return "CustomerInsightsEntity [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", UpdatedOn=" + UpdatedOn + "]";
	}

	
	
	
	
	

}
