package com.jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataStorage {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="4724";
		String query="create table user";
		try {
			Connection con= DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
