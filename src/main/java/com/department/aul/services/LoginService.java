package com.department.aul.services;

public class LoginService {
	
	public boolean isLogin(String userID, String password) {
		if (userID.equals("user123") && password.equals("pass123")) {
			return true;
		}
		return false;
	}

}
