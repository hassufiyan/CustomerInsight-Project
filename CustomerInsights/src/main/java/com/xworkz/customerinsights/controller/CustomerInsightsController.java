package com.xworkz.customerinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;
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
		System.out.println("Data is in customer controller");
//		model.addAttribute("", model)
		return  service.save(dto, model);
		
		
		
	}
	
}
