package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.Postdao;
import com.db.DBconnect;
import com.user.Post;

@WebServlet("/addNotes")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
		
		  System.out.println("UID: " + uid);
		    System.out.println("Title: " + title);
		    System.out.println("Content: " + content);
		
		Postdao po=new Postdao(DBconnect.getConn());
		boolean f=po.addNotes(title, content, uid);
		
		if(f) {
			System.out.println("Data Insert Sucessfully");
			response.sendRedirect("showNotes.jsp");
		}
		else {
			System.out.println("Dta not indert");
		}
	}

}
