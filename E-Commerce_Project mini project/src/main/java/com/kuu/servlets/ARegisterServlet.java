package com.kuu.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import com.kuu.dao.admin;
import com.kuu.entities.Admin;
import com.kuu.factories.AdminConnectionFactories;


import jakarta.servlet.annotation.WebServlet;
@WebServlet("/Aregister")
public class ARegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Admin admin = new Admin(first_name, last_name, password, address, city, state, email, phone);
		
		admin adminDAO = new admin(AdminConnectionFactories.getConnection());
		
		HttpSession session  = request.getSession();
		boolean f = adminDAO.addAdmin(admin);
		
		
		if(f) {
			session.setAttribute("succMsg", "Success: 201, Successfully Created");
			response.sendRedirect("AddAdmin.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Failure: 400, First Name or Last Name is missing");
			response.sendRedirect("AddAdmin.jsp");
			
		}
		
		
	}

}
