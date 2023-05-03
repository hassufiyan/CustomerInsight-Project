package com.xworkz.customerinsights.util;

import java.util.Base64;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;

public class Test {
	
	public static String encode(String password) {

        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
        return new String(encodedBytes);
    }

	public static String decode(String password) {

        byte[] encodedBytes = Base64.getDecoder().decode(password.getBytes());
        return new String(encodedBytes);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(encode("testtest12"));
		System.out.println(decode("dGVzdHRlc3QxMg=="));
	}

}
