package Onlineplatform;

public class User {
	private int user_id;
	private String username;
	private String email;
	private String Password; //should be hashed for security
	
	
	public User( String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.Password = password;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
