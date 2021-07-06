package fr.mauritius.Backpacker.controllers;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mauritius.Backpacker.domain.dtos.RoomView;
import fr.mauritius.Backpacker.domain.entities.Room;
import fr.mauritius.Backpacker.services.RoomService;

@RestController
@RequestMapping("/rooms")
@Secured({ "ROLE_ADMIN", "ROLE_BASIC" })
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
	this.service = service;
    }

    @GetMapping("")
    public List<Room> list() {
	return service.listAllRoom();
    }

    @GetMapping("/{id}")
    public RoomView getById(@PathVariable("id") Long id) {
	return service.getById(id);
    }

}
