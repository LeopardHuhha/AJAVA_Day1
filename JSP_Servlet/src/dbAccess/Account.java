package dbAccess;

public class Account {
	private int id;
	private String user;
	private String pass;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account() {
		super();
	}
	public Account(int id, String user, String pass, String email) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.email = email;
	}
	
	

}
