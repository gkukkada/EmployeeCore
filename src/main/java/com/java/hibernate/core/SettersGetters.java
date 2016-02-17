package com.java.hibernate.core;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;

public class SettersGetters {
	static User getUser(Session session, String username) {
		//check for existence
        User usr = (User)session.get(User.class, new String(username));
        //System.out.println("Saved Employee = " + employee.toString());
        return usr;
 
	}
	static void saveEmployee(Session session, int id) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setFname("Hibernate");
        emp.setLname("Example");
        emp.setAge(50);
        emp.setAddress("Sample Hibernate Address \nSome City, State Zipcode");
        session.save(emp);
	}
	static void saveUser(Session session, Map map ) {
        User usr = new User();   
        
        usr.setUsername((String) map.get("username"));
        usr.setPassword((String) map.get("password"));
        usr.setEmail((String) map.get("email"));
        usr.setFirstname((String) map.get("fname"));
        usr.setLastname((String) map.get("lname"));
        session.save(usr);
	}
	
	static Employee getEmployee(Session session, int empId) {
		//check for existence
        Employee employee = (Employee)session.get(Employee.class, new Integer(empId));
        //System.out.println("Saved Employee = " + employee.toString());
        return employee;
 
	}
	
	static Employee getEmployeeById(Session session, int empId) {
		String hql = "FROM Employee E WHERE E.id = " + empId;
		Query query = session.createQuery(hql);
		List results = query.list();
		if (results.isEmpty()) { return null;}
		return (Employee)results.get(0);
	}
	
	static Employee getAllEmployees(Session session) {
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		List results = query.list();
		if (results.isEmpty()) { return null;}
		return (Employee)results.get(0);
	}
}
