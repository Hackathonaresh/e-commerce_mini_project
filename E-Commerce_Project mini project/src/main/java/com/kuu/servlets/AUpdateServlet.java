package com.kuu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kuu.dao.admin;
import com.kuu.entities.Admin;
import com.kuu.factories.AdminConnectionFactories;
@WebServlet("/Aupdate")
public class AUpdateServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		Admin customer = new Admin(id,first_name, last_name, password, address, city, state, email, phone);
		
		admin customerDAO = new admin(AdminConnectionFactories.getConnection());
		
		HttpSession session  = request.getSession();
		
		boolean f = customerDAO.updateAdmin(customer);
		

		if(f) {
			session.setAttribute("succMsg", "200, Successfully Updated");
			response.sendRedirect("edit_admin.jsp");
			
		}else {
			session.setAttribute("errorMsg", "400, Body is Empty");
			response.sendRedirect("Adminfetch.jsp");
			
		}
	}

}
