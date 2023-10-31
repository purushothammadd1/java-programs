package com.ebooksshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {
	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","4724");
			Statement stmt=conn.createStatement();

			String strSelect="select title,author, price, qty from books where author ='Tan Ah Teck' OR price >= 30 ORDER BY price DESC, id ASC";
			System.out.println("The SQL statement is: "+ strSelect +"\n");
			ResultSet rset = stmt.executeQuery(strSelect);

			System.out.println("The records selected are:");
			int rowCount= 0;

			while(rset.next()) {
				String title= rset.getString("title");
				String author=rset.getString("author");
				double price = rset.getDouble("price");
				int qty=rset.getInt("qty");
				System.out.println(title+","+author+", "+price+", "+qty);
				++rowCount;
			}
			System.out.println("Total number of records = "+ rowCount);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
