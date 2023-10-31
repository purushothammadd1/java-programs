package com.jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query1 {

	public static void main(String[] args) throws Exception 
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="4724";
		String query= "select * from student";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(query);
	
		String userData="";
		
		while(rs.next()) {
			userData = rs.getInt(1)+ " : "+ rs.getString(2);
			System.out.println(userData);
		}
		st.close();
		con.close();
	}

}
