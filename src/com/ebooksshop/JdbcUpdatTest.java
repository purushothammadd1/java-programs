package com.ebooksshop;

import java.sql.*;
public class JdbcUpdatTest {
	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","4724");
			Statement stmt=conn.createStatement();

//			String strUpdate="update books set price =price*1.07, qty = qty+1 where id= 1001";
//			String strUpdate="update books set price =price+(0.50*price) where title='A cup of java' ";
			String strUpdate ="update books set qty = 0 where title ='A Teaspoon of java'";
			System.out.println("The SQL statement is: "+ strUpdate +"\n");
			int countUpdated = stmt.executeUpdate(strUpdate);
			System.out.println(countUpdated+ " records affected.\n");

			String strSelect="select * from books";
			System.out.println("The SQL statement is: "+ strSelect +"\n");
			ResultSet rset= stmt.executeQuery(strSelect);
			while(rset.next()) {
				System.out.println(rset.getInt("id")+ ", "+rset.getString("author")+","
						+rset.getString("title")+", "+rset.getDouble("price")+", "
						+rset.getInt("qty"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
