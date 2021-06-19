package fr.mauritius.Backpacker.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ck_booking")

public class Ckbooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ck_id", nullable = false)
    private Long id;
    private String ckid;

    private LocalDate DateBegin;
    private LocalDate DateEnd;
    private boolean isloaded;

    public boolean isIsloaded() {
	return isloaded;
    }

    public void setIsloaded(boolean isloaded) {
	this.isloaded = isloaded;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer mainCustomer;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room mainRoom;

//    @Column(name = "room_id", nullable = false)
//    private Long roomId;

    public Ckbooking() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCkid() {
	return ckid;
    }

    public void setCkid(String ckid) {
	this.ckid = ckid;
    }

    public LocalDate getDateBegin() {
	return DateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
	DateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
	return DateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
	DateEnd = dateEnd;
    }

    public Customer getMainCustomer() {
	return mainCustomer;
    }

    public void setMainCustomer(Customer mainCustomer) {
	this.mainCustomer = mainCustomer;
    }

    public Room getMainRoom() {
	return mainRoom;
    }

    public void setMainRoom(Room mainRoom) {
	this.mainRoom = mainRoom;
    }

    @Override
    public String toString() {
	return "Ckbooking [id=" + id + ", ckid=" + ckid + ", DateBegin=" + DateBegin + ", DateEnd=" + DateEnd
		+ ", isloaded=" + isloaded + ", mainCustomer=" + mainCustomer + ", mainRoom=" + mainRoom + "]";
    }

}
