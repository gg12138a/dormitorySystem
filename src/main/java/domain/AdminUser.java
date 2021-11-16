package domain;

public class AdminUser {
	private int id;
	private String email;
	private String password;
	private String username;
	
	
	public AdminUser(int id, String email, String password,String username) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username=username;
	}
	public AdminUser() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username + "]";
	}

	
	
}
