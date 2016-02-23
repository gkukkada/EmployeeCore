package com.java.hibernate.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;
import com.java.hibernate.core.util.HibernateUtil;
import com.java.hibernate.core.validations.UserDAO;

/**
 * Servlet implementation class App
 */
public class App extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (SettersGetters.getUser(session, username)!= null && username!="") {
			User usr = SettersGetters.getUser(session, username);
			if (UserDAO.validate(username, password, usr)) {
				resp.sendRedirect("/EmployeeCore/id.jsp");

			} else {
				req.setAttribute("err", "Invalid Login");
				RequestDispatcher view = getServletContext().getRequestDispatcher("/index.jsp");
				view.forward(req, resp);
			}
		} else {
			req.setAttribute("err", "No username Found DUDE!. Register Now.");
			RequestDispatcher view = getServletContext().getRequestDispatcher("/index.jsp");
			view.forward(req, resp);
		}
	}
}
