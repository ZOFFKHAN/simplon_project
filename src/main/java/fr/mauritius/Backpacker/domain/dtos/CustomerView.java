package fr.mauritius.Backpacker.domain.dtos;

public class CustomerView {

    private String lastname;
    private String firstname;
    private String email;
    private Long mainAccountId;
    private String useraccount;

    public CustomerView() {
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

    public String getUseraccount() {
	return useraccount;
    }

    public void setUseraccount(String useraccount) {
	this.useraccount = useraccount;
    }

    @Override
    public String toString() {
	return "CustomerView [lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
		+ ", mainAccountId=" + mainAccountId + ", useraccount=" + useraccount + "]";
    }

}
