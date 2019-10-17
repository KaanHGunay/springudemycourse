package com.khg.simpleweb;

public class UserValidationService {
	public boolean isUserValid(String userName, String password) {
		return userName.equals("Kaan") && password.equals("123");
	}
}
