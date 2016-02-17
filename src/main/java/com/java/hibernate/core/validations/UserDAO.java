package com.java.hibernate.core.validations;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;

public class UserDAO {
	public static boolean validate(String username, String password, User usr) {
		if (usr.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateid(Integer id, Employee emp) {

		if (id.equals(emp.getId())) {
			return true;
		} else {
			return false;
		}
	}
}
