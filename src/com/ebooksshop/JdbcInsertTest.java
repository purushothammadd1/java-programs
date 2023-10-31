package com.ebooksshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertTest {
	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval= true& useSSL=false&serverTimezone=UTC","root","4724");
			Statement stmt=conn.createStatement();
			
//			delete query 
			String strDetele="delete from books where id >= 3000 and id <4000";
			
			System.out.println("The SQL statement is: "+strDetele +"\n");
			int countDeleted = stmt.executeUpdate(strDetele);
			System.out.println(countDeleted+" records deleted. \n");
			strDetele ="delete from books where id >8000";
			System.out.println("The SQL statement is: "+strDetele +"\n");
			 countDeleted = stmt.executeUpdate(strDetele);
			System.out.println(countDeleted+" records deleted. \n");
			
//			insert query from the java to db
			String strInsert="insert into books values(3001,'Gone Fishing','Kumar',11.11,11 )";
			System.out.println("The SQL Statement is: "+ strInsert + "\n");
			int countInserted = stmt.executeUpdate(strInsert);
			System.out.println(countInserted+" records inserted. \n");

//			insert multiple records 
			strInsert = "insert into books values"+"(3002,'GoneFishing 2','kumar',22.22,22),"+"(3003,'Gone Fishing 3', 'kumar',33.33,30)";
			System.out.println("The SQL Statement is: "+strInsert+ "\n");
			countInserted= stmt.executeUpdate(strInsert);
			System.out.println(countInserted +" records inserted. \n");
			
//			insert a partial record
			strInsert ="insert into books(id,title, author) values (3004,'Fishing 101','kumar')";
			System.out.println("The sql statement is:"+ strInsert +"\n");
			countInserted = stmt.executeUpdate(strInsert);
			System.out.println(countInserted+" records inserted. \n");
//			insert record 8001, 8002
			strInsert ="insert into books values"+"(8001,'Java ABC','Kevin Jones', 15.55,55),"+"(8002,'Java xyz','kevin Jones',25.55,55)";
			System.out.println("The sql statement is:"+ strInsert +"\n");
			countInserted = stmt.executeUpdate(strInsert);
			System.out.println(countInserted+" records inserted. \n");
			
//			See the all records from the db table.
			String strSelect="select * from books";
			System.out.println("The SQL statement is: "+ strSelect+" \n");
			ResultSet rset= stmt.executeQuery(strSelect);
			while(rset.next()) {
				System.out.println(rset.getInt("id")+", " + rset.getString("author")+", "
						+rset.getString("title")+","+rset.getDouble("price")+", "+rset.getInt("qty"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
