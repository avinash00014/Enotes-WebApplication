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

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer note_id = Integer.parseInt(req.getParameter("note_id"));
		Postdao po=new Postdao(DBconnect.getConn());
		boolean f=po.deleteNotes(note_id);
		HttpSession sesion=req.getSession();
		if(f) {
			
			sesion.setAttribute("updateMSG","Notes delete Successfully");
			System.out.println("Data Delete Succcessfully");
			resp.sendRedirect("showNotes.jsp");
		}else {
			sesion.setAttribute("wrongMSG","Somethig Went Wrong On Server ");
			System.out.println("Somthong went into Server");
			resp.sendRedirect("showNotes.jsp");
		}
	}

	}

	

