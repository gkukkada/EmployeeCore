package com.java.hibernate.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;
import com.java.hibernate.core.util.HibernateUtil;
import com.java.hibernate.core.validations.UserDAO;

/**
 * Servlet implementation class User
 */
public class UserApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		String username = req.getParameter("username");

		if (SettersGetters.getUser(session, username) == null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", req.getParameter("username"));
			map.put("password", req.getParameter("password"));
			map.put("email", req.getParameter("email"));
			map.put("fname", req.getParameter("firstname"));
			map.put("lname", req.getParameter("lastname"));
			SettersGetters.saveUser(session, map);

			session.getTransaction().commit();
			resp.sendRedirect("/EmployeeCore/index.jsp");

		} else {
			req.setAttribute("err", "Given Username is Not Available. Please Choose another.");
			RequestDispatcher view = getServletContext().getRequestDispatcher("/register.jsp");
			view.forward(req, resp);
		}

	}

}
