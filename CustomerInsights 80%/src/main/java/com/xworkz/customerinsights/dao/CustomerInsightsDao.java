package com.xworkz.customerinsights.dao;

import java.util.List;

import com.xworkz.customerinsights.entity.CustomerInsightsEntity;

public interface CustomerInsightsDao {
	
	public boolean save(CustomerInsightsEntity entity);

	public CustomerInsightsEntity findByEmail(String email);

	public CustomerInsightsEntity findByEmailAndPassword(String email);

	int updateByEmailId(String email, int wpc,String status);

	public boolean updateOtpByEmail(int otp, String email);

	public int getOtpByEmail(String email);

	public boolean updatePasswordByEmail(String email, String password);

//	public int updateAccounStatusByEmail(String status, String email,);

}
