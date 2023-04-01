package com.xworkz.customerinsights.service;

import org.springframework.ui.Model;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;


public interface CustomerInsightsService {
	
	
 String save(CustomerInsightsDto dto,Model model);

}
