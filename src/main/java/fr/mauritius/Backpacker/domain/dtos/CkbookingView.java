package fr.mauritius.Backpacker.domain.dtos;

import java.time.LocalDate;

public class CkbookingView {
    private Long id;
    private String ckid;
    private LocalDate DateBegin;
    private LocalDate DateEnd;

    private Long mainCustomerId;
    // private Long roomId;
    private Long mainRoomId;
    private String usermail;

    private boolean isloaded;

    public CkbookingView() {
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

    public Long getMainCustomerId() {
	return mainCustomerId;
    }

    public void setMainCustomerId(Long mainCustomerId) {
	this.mainCustomerId = mainCustomerId;
    }

    public Long getMainRoomId() {
	return mainRoomId;
    }

    public void setMainRoomId(Long mainRoomId) {
	this.mainRoomId = mainRoomId;
    }

    public String getUsermail() {
	return usermail;
    }

    public void setUsermail(String usermail) {
	this.usermail = usermail;
    }

    public boolean isIsloaded() {
	return isloaded;
    }

    public void setIsloaded(boolean isloaded) {
	this.isloaded = isloaded;
    }

    @Override
    public String toString() {
	return "CkbookingView [id=" + id + ", ckid=" + ckid + ", DateBegin=" + DateBegin + ", DateEnd=" + DateEnd
		+ ", mainCustomerId=" + mainCustomerId + ", mainRoomId=" + mainRoomId + ", usermail=" + usermail
		+ ", isloaded=" + isloaded + "]";
    }

}
