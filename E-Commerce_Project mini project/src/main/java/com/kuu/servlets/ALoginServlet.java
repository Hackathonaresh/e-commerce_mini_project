package com.kuu.servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/Alogin")
public class ALoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		
		res.setContentType("text/html");

		PrintWriter out=res.getWriter();
		
		String first_name=req.getParameter("first_name");
			String last_name=req.getParameter("last_name");
			String password=req.getParameter("password");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
		
		
		PreparedStatement ps =con.prepareStatement("Select*from admin where first_name=? and last_name=? and password=?");
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, password);
		HttpSession session  = req.getSession();
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			session.setAttribute("succMsg", "Success:, Successfully Created");
			res.sendRedirect("AdminDashboard.jsp");
		}
		else
		{
			
			out.print("<h3 style='color:red'>email & password doesnt matched</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/Alogin.jsp");
			rd.include(req, res);
		}
		}
	catch(Exception e)
	{
		e.printStackTrace();
		
		res.setContentType("text/html");
		out.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
		RequestDispatcher rd = req.getRequestDispatcher("/Alogin.jsp");
		rd.include(req, res);
		
	}
			
	}
	
	
}	
