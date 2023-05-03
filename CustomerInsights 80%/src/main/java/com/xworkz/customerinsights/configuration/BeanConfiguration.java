package com.xworkz.customerinsights.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.customerinsights")
@EnableWebMvc
public class BeanConfiguration implements WebMvcConfigurer {

	public BeanConfiguration() {
		System.out.println("Started "+this.getClass().getSimpleName());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("view Controller");
		registry.addRedirectViewController("/","SignUp.jsp");
	}
	
	@Bean
	public ViewResolver addViewResolver() {
		return new InternalResourceViewResolver("/",".jsp");
	}
}
