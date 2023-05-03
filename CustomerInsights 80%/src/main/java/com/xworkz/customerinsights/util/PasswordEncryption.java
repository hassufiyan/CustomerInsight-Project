package com.xworkz.customerinsights.util;

import java.util.Base64;

public class PasswordEncryption {

	public static String encode(String password) {

        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
        return new String(encodedBytes);
    }

	public static String decode(String password) {

        byte[] encodedBytes = Base64.getDecoder().decode(password.getBytes());
        return new String(encodedBytes);
    }
}

