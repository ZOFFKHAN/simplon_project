package fr.mauritius.Backpacker.domain.dtos;

import javax.validation.constraints.Null;

public class CustomerCreate {

    private String lastname;
    private String firstname;
    private String email;

    @Null
    private Long mainAccountId;

    public CustomerCreate() {
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Long getMainAccountId() {
	return mainAccountId;
    }

    public void setMainAccountId(Long mainAccountId) {
	this.mainAccountId = mainAccountId;
    }

    @Override
    public String toString() {
	return "CustomerCreate [lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
		+ ", mainAccountId=" + mainAccountId + "]";
    }

}
