package com.xworkz.customerinsights.dto;

public enum AccountStatus {
	
	BLOCKED("Blocked"),UNBLOCKED("Unblocked");
		
	public String value;
	 
 AccountStatus(String value){
		this.value=value;
	}
 
 public String getValue(String value) {
	 return value;
 }

}
