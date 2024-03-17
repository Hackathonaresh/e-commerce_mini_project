package com.kuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kuu.entities.Admin;


public class admin {

	
	private Connection connection;

	public admin(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addAdmin(Admin admin) {
		
		boolean f = false;
		
		try {
			
			String sql = "insert into admin(first_name,last_name,password,address,city,state,email,phone) values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getFirst_name());
			preparedStatement.setString(2, admin.getLast_name());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getAddress());
			preparedStatement.setString(5, admin.getCity());
			preparedStatement.setString(6, admin.getState());
			preparedStatement.setString(7, admin.getEmail());
			preparedStatement.setString(8, admin.getPhone());
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	public List<Admin>getAllAdmin(){
		List<Admin> list  = new ArrayList<Admin>();
		Admin c =null;
		
		try {
			String sql = "select * from admin";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				c = new Admin();
				c.setId(rs.getInt(1));
				c.setFirst_name(rs.getString(2));
				c.setLast_name(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setCity(rs.getString(6));
				c.setState(rs.getString(7));
				c.setEmail(rs.getString(8));
				c.setPhone(rs.getString(9));
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
 	}
	
	public Admin getAdminById(int id) {
		Admin c = null;
		 try {
				String sql = "select * from admin where id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					c = new Admin();
					c.setId(rs.getInt(1));
					c.setFirst_name(rs.getString(2));
					c.setLast_name(rs.getString(3));
					c.setPassword(rs.getString(4));
					c.setAddress(rs.getString(5));
					c.setCity(rs.getString(6));
					c.setState(rs.getString(7));
					c.setEmail(rs.getString(8));
					c.setPhone(rs.getString(9));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return c;
	}
	
public boolean updateAdmin(Admin admin) {
		
		boolean f = false;
		
		try {
			
			String sql = "update admin set first_name=?,last_name=?,password=?,address=?,city=?,state=?,email=?,phone=? where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getFirst_name());
			preparedStatement.setString(2, admin.getLast_name());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getAddress());
			preparedStatement.setString(5, admin.getCity());
			preparedStatement.setString(6, admin.getState());
			preparedStatement.setString(7, admin.getEmail());
			preparedStatement.setString(8, admin.getPhone());
			preparedStatement.setInt(9, admin.getId());
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}

  public boolean deleteAdmin(int id) {
	  boolean f= false;
	  
	  try {
		  String sql = "delete from admin where id = ?";
		  PreparedStatement preparedStatement = connection.prepareStatement(sql);
		  preparedStatement.setInt(1, id);
		  

			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return f;
  }
	
	
}
