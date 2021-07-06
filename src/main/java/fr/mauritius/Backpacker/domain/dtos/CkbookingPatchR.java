package fr.mauritius.Backpacker.domain.dtos;

public class CkbookingPatchR {

    // private Long roomId;

    private Long mainRoomId;

    public CkbookingPatchR() {
    }

    public Long getMainRoomId() {
	return mainRoomId;
    }

    public void setMainRoomId(Long mainRoomId) {
	this.mainRoomId = mainRoomId;
    }

    @Override
    public String toString() {
	return "CkbookingPatchR [mainRoomId=" + mainRoomId + "]";
    }

}
