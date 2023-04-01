package com.xworkz.customerinsights.service;

import java.time.LocalTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.customerinsights.dao.CustomerInsightsDao;
import com.xworkz.customerinsights.dto.CustomerInsightsDto;
import com.xworkz.customerinsights.entity.CustomerInsightsEntity;

@Service
public class CustomerInsightsServiceImpl implements CustomerInsightsService {

	@Autowired
	CustomerInsightsDao dao;

	public CustomerInsightsServiceImpl() {
		System.out.println("CustomerInsights Service is running");
	}

	@Override
	public String save(CustomerInsightsDto dto, Model model) {
		if (dto != null) {
			CustomerInsightsEntity entity = new CustomerInsightsEntity();
			BeanUtils.copyProperties(dto, entity);
			entity.setCreatedBy(dto.getFristName());
			entity.setCreatedOn(LocalTime.now());
			String res = dao.save(entity);
			if (res != null) {
				model.addAttribute("Success", "Account created Successfully");
				return "SignUp";
			}

			model.addAttribute("Failed", "Account not created");
			return "SignUp";
		}
		model.addAttribute("Failed", "Account not created");
		return "SignUp";
	}

}
