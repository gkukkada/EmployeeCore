package com.java.hibernate.core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.hibernate.core.util.HibernateUtil;

/**
 * Servlet implementation class DBOEmployee
 */
public class DBOEmployee extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("#######################################################################");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		System.out.println(req.getParameter("remove"));
		int id = Integer.parseInt(req.getParameter("remove"));
		deleteEmployee(session, id);
		session.getTransaction().commit();
		req.setAttribute("success", "Record removed from database successfully.");
		RequestDispatcher view = getServletContext().getRequestDispatcher("/employee.jsp");
		view.forward(req, resp);
	}
	
	private static void deleteEmployee(Session session, int id){
		Query q = session.createQuery("delete Employee E WHERE E.id= "+id);
		q.executeUpdate();
	}

}
