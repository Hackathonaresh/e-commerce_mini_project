package com.kuu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kuu.dao.admin;
import com.kuu.factories.AdminConnectionFactories;
@WebServlet("/Adelete")
public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id  =  Integer.parseInt(request.getParameter("id"));
		
		admin dao = new admin(AdminConnectionFactories.getConnection());
		boolean f = dao.deleteAdmin(id);
		
		HttpSession session = request.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "200, Successfully deleted");
			response.sendRedirect("Adminfetch.jsp");
			
		}else {
			session.setAttribute("errorMsg", "500, Error Not deleted");
			response.sendRedirect("Adminfetch.jsp");
			
		}
		
	}

}
