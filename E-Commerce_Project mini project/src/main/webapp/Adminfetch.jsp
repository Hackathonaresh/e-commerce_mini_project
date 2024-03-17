<%@page import="com.kuu.entities.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.kuu.factories.AdminConnectionFactories"%>
<%@page import="com.kuu.dao.admin"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
 <%@page isELIgnored="false" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="all-css.jsp"%>
</head>
<body>

	<%@ include file="Adminnavbar.jsp"%>
	

	<div class="container p-3">
	<p class="text-center fs-1 ">All Customer Details</p>
	<c:if test="${not empty succMsg }">
						<p class="text-center text-sucess">${succMsg }</p>
						<c:remove var="succMsg"/>
						</c:if>
						<c:if test="${not empty errorMsg }">
						<p class="text-center text-sucess">${errorMsg }</p>
						<c:remove var="errorMsg"/>
						</c:if>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">First_Name</th>
					<th scope="col">Last_Name</th>
					<th scope="col">Password</th>
					<th scope="col">Address</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Action</th>
					
					
				</tr>
			</thead>
			<tbody>
			<%
			    admin dao = new admin(AdminConnectionFactories.getConnection());
			    List<Admin> list = dao.getAllAdmin();
			    for(Admin c : list)
			    {%>
			    
			     <tr>
					<th scope="row"><%=c.getFirst_name() %></th>
					<td><%=c.getLast_name() %></td>
					<td><%=c.getPassword() %></td>
					<td><%=c.getAddress() %></td>
					<td><%=c.getCity() %></td>
					<td><%=c.getState() %></td>
					<td><%=c.getEmail() %></td>
					<td><%=c.getPhone() %></td>
					<td><a href="edit_admin.jsp?id=<%=c.getId() %>" class="btn btn-sm btn-primary">Edit</a>
					<a href="Adelete?id=<%=c.getId() %>" class="btn btn-sm btn-danger ms-1">Delete</a>
					</td>
			    	</tr>
			    <%}
			
			%>
				
					
				
				
				
			</tbody>
		</table>
	</div>


</body>
</html>