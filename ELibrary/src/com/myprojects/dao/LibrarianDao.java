package com.myprojects.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.myprojects.beans.*;

public class LibrarianDao {

	public static int save(Librarian bean) {
		int status =0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into e_librarian values(?,?,?,?,?)");
	    	ps.setInt(1, bean.getID());
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Librarian bean) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update e_librarian set name=?, email=?, password=?,mobile=? where id=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			ps.setInt(5, bean.getID());
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Librarian> view() {
		ArrayList<Librarian> list = new ArrayList<Librarian>();
		try {
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from e_librarian");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
						int id = rs.getInt(1);
				String name = rs.getString(2);
					String email = rs.getString(3);
					String password = rs.getString(4);
					long mobile = rs.getLong(5);
					Librarian librarian = new Librarian(id, name, email, password, mobile);
					list.add(librarian);
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Librarian viewById(int id) {
		Librarian bean = new Librarian();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from e_librarian where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean.setID(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from e_librarian where id =?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean authenticate(String email, String password) {
		boolean status = false;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_librarian where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}	
}
