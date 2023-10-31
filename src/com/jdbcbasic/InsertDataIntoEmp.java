package com.jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoEmp {
	public static void main(String[] args) throws SQLException {
		final String URL ="jdbc:mysql://localhost:3306?user=root&&password=4724";
		String query="insert into employeedb.employee values(1,'Bikash Dubey',30000.00,'CS')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(URL);
			System.out.println("connection established");
			Statement st=con.createStatement();
			st.execute(query);
			System.out.println("Data Inserted");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
