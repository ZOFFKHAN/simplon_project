package fr.mauritius.Backpacker.domain.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import fr.mauritius.Backpacker.validation.DateDiffDesc;

@DateDiffDesc
public class CkbookingCreate {
    private Long id;

    private String ckid;
    @Future(message = "date can't be before today !")
    private LocalDate dateBegin;
    @Future(message = "date can't be before today !")
    private LocalDate dateEnd;
    private Long mainCustomerId;
    @NotNull(message = "Roomid should be provided !")
    private Long mainRoomId;

    // private Long roomId;

    private boolean isloaded;

    public CkbookingCreate() {
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

    public boolean isIsloaded() {
	return isloaded;
    }

    public void setIsloaded(boolean isloaded) {
	this.isloaded = isloaded;
    }

    @Override
    public String toString() {
	return "CkbookingCreate [id=" + id + ", ckid=" + ckid + ", dateBegin=" + dateBegin + ", dateEnd=" + dateEnd
		+ ", mainCustomerId=" + mainCustomerId + ", mainRoomId=" + mainRoomId + ", isloaded=" + isloaded + "]";
    }

}
