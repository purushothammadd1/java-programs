package Productjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductManager {
	private Connection connection;
	
	public ProductManager(String url, String username, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			
			connection =DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createProduct(Product product) {
		String sql="Insert into products (name, price, description) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
			
		
		if(connection != null) {
			connection.close();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
