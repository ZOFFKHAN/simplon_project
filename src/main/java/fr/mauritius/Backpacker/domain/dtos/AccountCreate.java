package fr.mauritius.Backpacker.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AccountCreate {

    @Email
    @NotBlank
    // @Uniquemail
    @Size(min = 1, max = 255, message = "number of character between ")
    private String username;
    @Size(min = 8, max = 12, message = "number of character between 8 and 12 ")
    private String password;
    // private boolean enabled;

    public AccountCreate() {

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

    @Override
    public String toString() {
	return "AccountCreate [username=" + username + ", password=PROTECTED,]";
    }

}
