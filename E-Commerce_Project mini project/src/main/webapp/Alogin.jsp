
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	
	
 <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200">
<%@ include file="all-css.jsp"%>
</head>
<body class="red">
	<%@ include file="Adminnavbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Login</p>
						
						<c:if test="${not empty succMsg }">
						<p class="text-center text-sucess">${succMsg }</p>
						<c:remove var="succMsg"/>
						</c:if>
						<c:if test="${not empty errorMsg }">
						<p class="text-center text-sucess">${errorMsg }</p>
						<c:remove var="errorMsg"/>
						</c:if>
						
						<form action="Alogin" method="post">
							<div class="mb-3">
								<label class="form-label">First_name</label> <input
									name="first_name" type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">last_name</label> <input
									name="last_name" type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">password</label> <input
									name="password" type="password" class="form-control">

							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>