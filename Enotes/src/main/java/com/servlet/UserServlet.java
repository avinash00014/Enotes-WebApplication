package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.db.DBconnect;
import com.user.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fname");
		String email = req.getParameter("useremail");
		String password = req.getParameter("userpass");
		
		
		UserDetails us=new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		
		UserDao dao=new UserDao(DBconnect.getConn());
		boolean f=dao.addUser(us);
		
		HttpSession session;
		if(f) {
			session=req.getSession();
			session.setAttribute("reg-sucess", "Registration Sucessfully");
			resp.sendRedirect("register.jsp");
		}else {
			session=req.getSession();
			session.setAttribute("failed-msg","Somthing Went Wrong on Server");
			resp.sendRedirect("register.jsp");
		}
	}

}
