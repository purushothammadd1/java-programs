package Onlineplatform;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class OnlineMainApp {
	public static void main(String[] args) {

		try {
			Connection connection=DatabaseConnection.getConnection();
			
			if(connection != null) {
//				System.out.println("Database connection sucessful!");
			
			UserDao userDao = new UserDao(connection);
			Scanner sc=new Scanner(System.in);

			System.out.println("Enter username: ");
			String username= sc.nextLine();
			System.out.println("Enter emailId: ");
			String email = sc.nextLine();
			System.out.println("Enter password: ");
			String password = sc.nextLine();

			User user= new User(username, email, password);

			userDao.createUser(user);
			System.out.println("User inserted successfully! ");
			userDao.closeConnection();
			}else {
				System.out.println("Database connection failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
