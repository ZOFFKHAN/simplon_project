package fr.mauritius.Backpacker.domain.dtos;

public class UserView {
    private int id;
    private String userName;
    private String password;
    private String role;
    private int enabled;

    public UserView() {
    }

    public UserView(int id, String userName, String password, String role, int enabled) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.role = role;
	this.enabled = enabled;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public int getEnabled() {
	return enabled;
    }

    public void setEnabled(int enabled) {
	this.enabled = enabled;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + ", enabled="
		+ enabled + "]";
    }

//other setters and getters
}
