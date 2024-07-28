<%@page import="com.user.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBconnect"%>
<%@page import="com.dao.Postdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please Login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/nav.jsp"%>
	
	<%
		String updateMsg=(String)session.getAttribute("updateMSG");
	if(updateMsg!=null){%>
		<div class="alert alert-success" role="alert"><%=updateMsg%></div>
	<%
	session.removeAttribute("updateMSG");
	}
	
	%>
	
	
	<%
		String wrongMSG=(String)session.getAttribute("wrongMSG");
	if(wrongMSG!=null){%>
		<div class="alert alert-danger" role="alert"><%=wrongMSG%></div>
	<%
	session.removeAttribute("updateMSG");
	}
	
	%>

	<div class="container">
		<h2 class="text-center">All Notes</h2>


		<div class="row">
			<div class="col-md-12">

				<%
				if (user3 != null) {
					Postdao ob = new Postdao(DBconnect.getConn());
					List<Post> post = ob.getdta(user3.getId());
					for (Post po : post) {
				%>
				<div class="card mt-3 br">
					<img alt="notes" src="img/notes.jpeg"
						class="card-img-top mt-2 mx-auto " style="max-width: 100px">
					<div class="card-body p-4">



						<h5 class="card-title"><%= po.getTitle() %></h5>
						<p><%= po.getContant() %></p>


						<p>
							<b class="text-success">Published By:<%= user3.getName() %></b></br> <b class="text-primary"></b>
						</p>

						<p>
							<b class="text-success">Published Date :<%= po.getpDate() %></b></br> <b
								class="text-success"></b>
						</p>

						<div class="container text-center mt-12">
							<a href="deleteServlet?note_id=<%= po.getId() %>" class="btn btn-danger">Delete</a>
							
							
							
							<a href="edit.jsp?note_id=<%= po.getId() %>" class="btn btn-primary">Edit</a>
						</div>
					</div>

				</div>
				<%
				}

				}
				%>



			</div>

		</div>

	</div>
</body>
</html>