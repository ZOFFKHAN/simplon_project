package fr.mauritius.Backpacker.domain.dtos;

public class AccountView {

    private String username;
    private String password;
    private boolean enabled;
//    private boolean Adefault;

    public AccountView() {

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

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    @Override
    public String toString() {
	return "AccountView [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
    }

}
