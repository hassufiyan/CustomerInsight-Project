package com.xworkz.customerinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;
import com.xworkz.customerinsights.entity.CustomerInsightsEntity;
import com.xworkz.customerinsights.service.CustomerInsightsService;

@Component
@RequestMapping("/")
public class CustomerInsightsController {
	
	@Autowired
	CustomerInsightsService service;

	public CustomerInsightsController() {
		System.out.println("Started "+this.getClass().getSimpleName());
	}

	@RequestMapping("/onSave")
	public String save(CustomerInsightsDto dto,Model model) {
		System.out.println(dto);
		
		System.out.println(dto.getPassword().length());
		System.out.println(dto.getConfirmPassword().length());
		System.out.println("Data is in customer controller");
//		model.addAttribute("", model)
		return service.save(dto, model);
		
		
		
	}
	
	@RequestMapping("/logIn")
	public String logIn(String email,String password,Model model) {
		return service.login(email,password, model);
		
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotPassword(String email,Model model) {
	String	res= service.forgotPassword(email,model);
	
		if(res!=null) {
			model.addAttribute("getEmail",res);
		return "EnterOtp";
		}
		return "ForgotPassword";
	}
	
	@RequestMapping("/validateOtp")
	public String validateOtpByEmail(String email,int otp,Model model) {
		System.out.println("iam in otp validation controller");
	boolean	res=service.validateOtpByEmail(email,otp,model);
	
	if(res){
		System.out.println("Successfully validated");
		return "ResetPassword";
	}
	else {
		System.out.println("Validation failed");
		return "EnterOtp";
	}
	}
	
	@RequestMapping("/resetPassword")
	public String resetPasswordByEmail(String email,String password,String confirmPassword,Model model,CustomerInsightsEntity entity) {
		boolean	res=service.resetPasswordByEmail(email,password,confirmPassword,model, entity);	
		System.out.println(password);
		System.out.println(confirmPassword);
		if(res) {
			System.out.println("password reset Successfull");
			return "ResetPassword";
		}
		else {
			System.out.println("Password reset failed");
			return "ResetPassword";
		}
	}
	
}
