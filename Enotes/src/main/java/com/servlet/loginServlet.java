package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import com.dao.UserDao;
import com.db.DBconnect;
import com.user.UserDetails;

@WebServlet("/logingServlet")
public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("useremail");
		String pass=request.getParameter("userpass");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(pass);
		
		UserDao dao=new UserDao(DBconnect.getConn());
		UserDetails user=dao.loginUser(us);
		
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("userD",user);
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute(" loging-flaid","Invalid UserName And Password");
			response.sendRedirect("login.jsp");
		}

}
}