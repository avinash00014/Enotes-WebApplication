package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			HttpSession session=request.getSession();
			session.removeAttribute("userD");
			
			HttpSession sesion2=request.getSession();
			sesion2.setAttribute("logot-MSG","Logout Sucessfully");
			response.sendRedirect("login.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
