package com.xworkz.customerinsights.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="Customer_Insights")
@NamedQuery(name="findByEmail",query="Select entity from CustomerInsightsEntity entity where entity.email=:eid")
@NamedQuery(name="findByEmailAndPassowrd",query="Select entity from CustomerInsightsEntity entity where entity.email=:eid")
@NamedQuery(name="updateByEmailId",query="update CustomerInsightsEntity entity set entity.wrongPasswordCount=:wpc,entity.acc_Status=:acs where entity.email=:eid")
@NamedQuery(name="updateOtpByEmailId",query="update CustomerInsightsEntity entity set entity.otp=:otp where entity.email=:email")
@NamedQuery(name="getOtpByEmail",query="Select entity.otp from CustomerInsightsEntity entity where entity.email=:email")
@NamedQuery(name="updatePassword",query="Update CustomerInsightsEntity entity set entity.password=:pwd where entity.email=:eid")
public class CustomerInsightsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	
	@Column(name="ID")
	private int id;
	
	
	@NotBlank(message="firstName should not be blank")
	@Column(name="firstName")
	private String firstName;
	
	
	@NotBlank(message="lastName should not be blank")
	@Column(name="lastName")
	private String lastName;
	
	
	@Email
	@NotBlank(message="email should not be blank")
	@Column(name="email")
	private String email;
	
	
	@NotBlank(message="password should not be blank")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="dateOfBirth should not be blank")
	@Column(name="dateOfBirth")
	private String dateOfBirth;
	
	
	@NotBlank(message="gender should not be blank")
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="createdBy")
	private String createdBy;
	
	

	@Column(name="createdOn")
	private LocalTime createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="wrongPasswordCount")
	private int wrongPasswordCount;
	
	@Column(name="acc_Status")
	private String acc_Status;
	
	@Column(name="otp")
	private int otp;
	

	public CustomerInsightsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerInsightsEntity(int id, @NotBlank(message = "firstName should not be blank") String firstName,
			@NotBlank(message = "lastName should not be blank") String lastName,
			@Email @NotBlank(message = "email should not be blank") String email,
			@NotBlank(message = "password should not be blank") String password,
			@NotBlank(message = "dateOfBirth should not be blank") String dateOfBirth,
			@NotBlank(message = "gender should not be blank") String gender, String createdBy, LocalTime createdOn,
			String updatedBy, String updatedOn, int wrongPasswordCount, String acc_Status, int otp) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.wrongPasswordCount = wrongPasswordCount;
		this.acc_Status = acc_Status;
		this.otp = otp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public void setCreatedOn(LocalTime createdOn) {
		this.createdOn = createdOn;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	public int getWrongPasswordCount() {
		return wrongPasswordCount;
	}


	public void setWrongPasswordCount(int wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
	}


	public String getAcc_Status() {
		return acc_Status;
	}


	public void setAcc_Status(String acc_Status) {
		this.acc_Status = acc_Status;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}


	@Override
	public String toString() {
		return "CustomerInsightsEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + ", wrongPasswordCount=" + wrongPasswordCount + ", acc_Status=" + acc_Status + ", otp="
				+ otp + "]";
	}


	





	
	
	
	
	

}
