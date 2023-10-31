package Onlineplatform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private Connection connection;

	public UserDao (Connection connection) {
		this.connection=connection;
		System.out.println("connectionin UserDao constructor: "+ connection);
	}

	public void createUser(User user) throws SQLException {
		String sql= "Insert into user(username,emailId, password) values(?,?,?)";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("Database driver not found");
		}
	}
	public User getUserById(int userId) throws SQLException{
		String sql="select * from user where user_id= ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, userId);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					User user= new User();
					user.setUser_id(resultSet.getInt("user_id"));
					user.setUsername(resultSet.getString("username"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					return user;
				}
			}

		}
		return null;	
	}
	public User getUserByUsername(String username) throws SQLException {
		String sql="SELECT * from User where username= ? ";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			preparedStatement.setString(1,username);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					User user = new User();
					user.setUser_id(resultSet.getInt("user_Id"));
					user.setUsername(resultSet.getString("username"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					return user;
				}
			}
		}
		return null;

	}
	//update the user details or information
	public void updateUser(User user) throws SQLException {
		String sql="UPDATE User SET username = ?, email = ?,password = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getUser_id());
			preparedStatement.executeUpdate();
		}
	}
	//delete a user by user_id
	public void deleteUser(int userId) throws SQLException {
		String sql = "DELETE FROM User WHERE user_id =?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		}
	}
	//Retrive all users
	public List<User> getAllUsers() throws SQLException {
		List<User> userList= new ArrayList<>();
		String sql="SELECT * from User";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet= preparedStatement.executeQuery()){
			while(resultSet.next()) {
				User user = new User();
				user.setUser_id(resultSet.getInt("User_id"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				userList.add(user);
			}
		}
		return userList;

	}

	public void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();		
		}
	}

}
