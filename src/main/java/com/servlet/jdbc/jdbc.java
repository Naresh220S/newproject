package com.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class jdbc {
	static jdbc mysql =new jdbc();
	static Connection con;
	
	private jdbc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mercedesbenz","root","SHOBHA@6305s");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getinstance() {
		return mysql.con;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(jdbc.getinstance());
	}
}
	