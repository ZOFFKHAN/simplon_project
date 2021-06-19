package fr.mauritius.Backpacker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.mauritius.Backpacker.domain.dtos.RoomView;
import fr.mauritius.Backpacker.domain.entities.Room;
import fr.mauritius.Backpacker.repositories.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repo;

    public RoomServiceImpl(RoomRepository repo) {
	this.repo = repo;
    }

    public RoomView getById(Long id) {
	Room room = repo.getById(id).get();
	RoomView view = new RoomView();
	view.setId(id);
	view.setDescription(room.getDescription());
	view.setRoom(room.getRoom());
	view.setCapacity(room.getCapacity());
	view.setPrice(room.getPrice());
	view.setStatus(room.getStatus());
	return view;

    }

    @Override
    public List<Room> listAllRoom() {
	return repo.findAll();

    }

}
