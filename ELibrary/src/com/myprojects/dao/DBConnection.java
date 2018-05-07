package com.myprojects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import oracle.jdbc.driver.OracleDriver;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sarika","sst208");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
