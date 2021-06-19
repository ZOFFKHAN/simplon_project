package fr.mauritius.Backpacker.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String lastname;
    private String firstname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account mainAccount;

    public Customer() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public Account getMainAccount() {
	return mainAccount;
    }

    public void setMainAccount(Account mainAccount) {
	this.mainAccount = mainAccount;
    }

    @Override
    public String toString() {
	return "Customer [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
		+ ", mainAccount=" + mainAccount + "]";
    }

}
