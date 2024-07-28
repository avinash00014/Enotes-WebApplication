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
<title>ADD NOTES</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="all_component/nav.jsp"%>
		<h1 class="text-center">ADD YOUR NOTES</h1>
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<form action="addNotes" method="post">
						<div class="form-group">


							<%
							UserDetails us = (UserDetails) session.getAttribute("userD");
							if (us != null) {
							%>

							<input type="hidden" value="<%=us.getId()%>" name="uid">

							<%
							}
							%>


							<div class="c">
								<label for="exampleInputEmail1">Enter Title</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="title" name="title"
									required="required">
							</div>
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"></textarea>


						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">ADD</button>

						</div>
					</form>

				</div>
			</div>
			<%@include file="all_component/footer.jsp"%>

		</div>




	</div>
</body>
</html>