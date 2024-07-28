<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.db.DBconnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp"%>

<style type="text/css">
.back-img {
	background: url("img/books.jpeg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
<%

Connection conn=DBconnect.getConn();
System.out.println(conn);

%>


	<%@include file="all_component/nav.jsp"%>
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class=" text-white">
				<i class="fa fa-book" aria-hidden="true"></i>E Notes-Save Your Notes
			</h1>
			<a href="login.jsp" class="btn btn-light "><i
				class="fa fa-user-circle-o" aria-hidden="true"></i>Login</a> <a
				href="register.jsp" class="btn btn-light "><i
				class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
		</div>

	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>