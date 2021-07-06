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
@Table(name = "check_bookings")

public class Ckbooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ck_id")
    private Long id;
    private String ckid;

    @Column(name = "date_begin")
    private LocalDate dateBegin;
    @Column(name = "date_end")
    private LocalDate dateEnd;
    private boolean isloaded;

    public boolean isIsloaded() {
	return isloaded;
    }

    public void setIsloaded(boolean isloaded) {
	this.isloaded = isloaded;
    }

    @ManyToOne
    // @JoinColumn(name = "customer_id", nullable = false)
    @JoinColumn(name = "customer_id")
    private Customer mainCustomer;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room mainRoom;

    private Long roomid;

    public void addRoom(Room room) {
	mainRoom = room;
	roomid = mainRoom.getId();

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
	return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
	this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
	return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
	this.dateEnd = dateEnd;
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

    public Long getRoomid() {
	return roomid;
    }

    public void setRoomid(Long roomid) {
	this.roomid = roomid;
    }

    @Override
    public String toString() {
	return "Ckbooking [id=" + id + ", ckid=" + ckid + ", dateBegin=" + dateBegin + ", dateEnd=" + dateEnd
		+ ", isloaded=" + isloaded + ", mainCustomer=" + mainCustomer + ", mainRoom=" + mainRoom + ", roomid="
		+ roomid + "]";
    }

}
