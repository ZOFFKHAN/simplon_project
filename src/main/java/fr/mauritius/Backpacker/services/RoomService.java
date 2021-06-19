package fr.mauritius.Backpacker.services;

import java.util.List;

import fr.mauritius.Backpacker.domain.dtos.RoomView;
import fr.mauritius.Backpacker.domain.entities.Room;

public interface RoomService {

    RoomView getById(Long id);

    List<Room> listAllRoom();

}
