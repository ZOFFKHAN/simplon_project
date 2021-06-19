package fr.mauritius.Backpacker.domain.dtos;

public class CkbookingPatchR {

    private Long roomId;

    // private Long mainRoomId;

    public CkbookingPatchR() {
    }

    public Long getRoomId() {
	return roomId;
    }

    public void setRoomId(Long roomId) {
	this.roomId = roomId;
    }

    @Override
    public String toString() {
	return "CkbookingPatchR [roomId=" + roomId + "]";
    }

}
