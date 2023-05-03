package com.xworkz.customerinsights.service;

import org.springframework.ui.Model;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;

import com.xworkz.customerinsights.entity.CustomerInsightsEntity;



public interface CustomerInsightsService {
	
	
 String save(CustomerInsightsDto dto,Model model);
 
CustomerInsightsEntity findByEmail(String email,Model model);
 
// CustomerInsightsEntity findByEmailAndPassword(String email,String password);

String login(String email,String password, Model model);

int updateByEmailId(String email, int wpc,String status);

String forgotPassword(String email,Model model);

int generateOtp();

boolean updateOtpByEmail(int otp,String email);

boolean sendOtpByEmail(String email,int otp);
//int updateAccounStatusByEmail(String status,String email);


int getOtpByEmail(String email);

boolean validateOtpByEmail(String email, int otp,Model model);

boolean resetPasswordByEmail(String email, String password, String confirmPassword, Model model,CustomerInsightsEntity entity);

boolean updatePasswordByEmail(String email,String password);


}
