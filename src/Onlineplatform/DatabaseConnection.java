package Onlineplatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String url= "jdbc:mysql://localhost:3306/product";
	private static final String username ="root";
	private static final String password ="4724";
	
	private static Connection connection;
	
	private DatabaseConnection() {
		
	}
	public static Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection =DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new SQLException("Database driver not found");
			}
		}
		return connection;
		
	}
	public static void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

}
