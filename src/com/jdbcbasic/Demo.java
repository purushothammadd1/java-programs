package com.jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "4724";
		String query= "select name from student where id=3";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, username,password);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		String name= rs.getString("name");
		System.out.println(name);
		
		st.close();
		con.close();
	}

}
