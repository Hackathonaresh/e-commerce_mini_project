package com.kuu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/buy")
public class buy extends HttpServlet 
{
	  protected void doPost(HttpServletRequest req ,HttpServletResponse res ) throws ServletException ,IOException
	  {
		  PrintWriter out=res.getWriter();
		  String first_name=req.getParameter("first_name");
		  String last_name=req.getParameter("last_name");
		  String phone=req.getParameter("phone");
		  String address=req.getParameter("address");
		  try 
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
			   PreparedStatement ps=conn.prepareStatement("insert into buy values(?,?,?,?)");
			   ps.setString(1, first_name);
			   ps.setString(2, last_name);
			   ps.setString(3, phone);
			   ps.setString(4, address);
			   int count= ps.executeUpdate();
			   if(count > 0)
			   {
				   res.setContentType("text/html");
				   out.print("<h3 style='color:green'>Successful!</h3>");
				   RequestDispatcher rd=req.getRequestDispatcher("/complete.jsp");
				   rd.include(req, res);
			   }
			   else 
			   {
				   res.setContentType("text/html");
				   out.print("<h3 style='color:red'>due to some technical issue..</h3>");
				   RequestDispatcher rd=req.getRequestDispatcher("/buy.jsp");
				   rd.include(req, res);
			   }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
			  res.setContentType("text/html");
			   out.print("<h3 style='color:red'>Exception occured : "+e.getMessage()+"</h3>");
			   RequestDispatcher rd=req.getRequestDispatcher("/buy.jsp");
			   rd.include(req, res);
		  }
		  }
}
