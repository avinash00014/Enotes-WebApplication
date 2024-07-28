<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<%@include file="all_component/allcss.jsp"%>

</head>
<body>

	<%@include file="all_component/nav.jsp"%>
	<div class="container-fluig div-color">
		<div class="row">
			<div class="col-mid-5 offset-md-5">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>

						<h4>Login</h4>
					</div>


					<%
					String invalidMsg = (String) session.getAttribute("loging-flaid");
					if (invalidMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<%
					session.removeAttribute("loging-flaid");
					}
					%>
					<%
					String withoutlogin = (String) session.getAttribute("login-error");
					if (withoutlogin != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutlogin%></div>
					<%
					session.removeAttribute("login-error");

					}
					%>

					<%
					String lgMSG = (String) session.getAttribute("logot-MSG");
					if (lgMSG != null) {
					%>

					<div class="alert alert-success" role="alert"><%=lgMSG%></div>

					<%
					session.removeAttribute("logot-MSG");
					}
					%>
					<div class="card-body">
						<form action="logingServlet" method="post">
							<div class="form-group">
								<label for="Email1">Email address</label> <input type="email"
									class="form-control" id="Email1" aria-describedby="emailHelp"
									placeholder="Enter email" name="useremail">

							</div>
							<div class="form-group">
								<label for="Password1"> Enter Password</label> <input
									type="password" class="form-control" id="Password1"
									placeholder="Password" name="userpass">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>

					</div>
				</div>


			</div>
		</div>
	</div>
	<div class="container-fluid bg-dark mt-1">
		<p class="text-center text-white">Note: Any Error Occure Than
			Contact CodeWith Aviansh Disigned And Developed by</p>
		<p class="text-center text-white">All Reight Reserve
			@CodeWithAvinash2022-24</p>
	</div>

</body>
</html>