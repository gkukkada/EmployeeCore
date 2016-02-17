package com.java.hibernate.core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.util.HibernateUtil;
import com.java.hibernate.core.validations.UserDAO;

/**
 * Servlet implementation class EmployeeIDInput
 */
public class EmployeeIDInput extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this is employeeid");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer id = null;
		try{
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException nm) {
			id =null;
		}
		
		if (id!=null && SettersGetters.getEmployee(session, id) != null) {
			Employee emp = SettersGetters.getEmployeeById(session, id);
			if (UserDAO.validateid(id, emp)) {
				req.setAttribute("empObj", emp);
				RequestDispatcher view = getServletContext().getRequestDispatcher("/employee.jsp");
				view.forward(req, resp);
			} else {
				req.setAttribute("err", "Enter valid Employee ID");
				RequestDispatcher view = getServletContext().getRequestDispatcher("/id.jsp");
				view.forward(req, resp);
			}
		} else {
			req.setAttribute("err", "Employee record Not Found");
			RequestDispatcher view = getServletContext().getRequestDispatcher("/id.jsp");
			view.forward(req, resp);
		}
	}
}
