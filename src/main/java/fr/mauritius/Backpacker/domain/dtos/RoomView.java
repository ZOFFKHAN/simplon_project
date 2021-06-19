package fr.mauritius.Backpacker.domain.dtos;

public class RoomView {

    private Long id;

    private String room;

    private String description;
    private int capacity;
    private int price;
    private String status;

    public RoomView() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getRoom() {
	return room;
    }

    public void setRoom(String room) {
	this.room = room;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public int getCapacity() {
	return capacity;
    }

    public void setCapacity(int capacity) {
	this.capacity = capacity;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "RoomView [id=" + id + ", room=" + room + ", description=" + description + ", capacity=" + capacity
		+ ", price=" + price + ", status=" + status + "]";
    }

}
