package domain;


public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private String location;

    public User() {
    }


	public User(int id, String email, String username, String password, String location) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.location = location;
	}



	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", location=" + location + "]";
	}





}
