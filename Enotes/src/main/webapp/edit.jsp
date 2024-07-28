<%@page import="com.db.DBconnect"%>
<%@page import="com.dao.Postdao"%>
<%@page import="com.user.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");
if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","Please Login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
<%
String noteIdParam = request.getParameter("note_id");
Post post = null;
if (noteIdParam != null) {
	try {
		int noteId = Integer.parseInt(noteIdParam);
		Postdao postDao = new Postdao(DBconnect.getConn());
		post = postDao.getDataById(noteId);
		if (post == null) {
			out.println("Post not found for the given ID.");
			return;
		}
	} catch (NumberFormatException e) {
		out.println("Invalid note ID.");
		return;
	}
} else {
	out.println("No note ID provided.");
	return;
}
%>

<%
int noteId = Integer.parseInt(noteIdParam);
Postdao post1=new Postdao(DBconnect.getConn());
Post p=post1.getDataById(noteId);


%>

	<div class="container-fluid">
		<%@include file="all_component/nav.jsp"%>
		<h1 class="text-center">Edit YOUR NOTES</h1>
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<form action="noteEditServlet" method="post">
					
					<input type="hidden" value="<%= noteId %>" name="noteId">
						<div class="form-group">



							<div class="c">
								<label for="exampleInputEmail1">Enter Title</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="title" name="title"
									required="required" value="<%= p.getTitle()%>">
							</div>
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"><%= p.getContant()%> </textarea>


						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">ADD NOTES</button>

						</div>
					</form>

				</div>
			</div>
			<%@include file="all_component/footer.jsp"%>

		</div>




	</div>
</body>
</html>