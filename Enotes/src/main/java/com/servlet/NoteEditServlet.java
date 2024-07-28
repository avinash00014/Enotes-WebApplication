package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.Postdao;
import com.db.DBconnect;

@WebServlet("/noteEditServlet")
public class NoteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		try {
			Integer noteId = Integer.parseInt(request.getParameter("noteId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Postdao dao=new Postdao(DBconnect.getConn());
				boolean f=dao.postUpadate(noteId, title, content);
				if(f) {
					System.out.println("Data Successfully Update");
					HttpSession session=request.getSession();
					session.setAttribute("updateMSG","Notes Update Successfully");
					response.sendRedirect("showNotes.jsp");
				}else {
					System.out.println("Data Not Insert");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
