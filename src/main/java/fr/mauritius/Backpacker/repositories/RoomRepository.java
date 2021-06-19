package fr.mauritius.Backpacker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mauritius.Backpacker.domain.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> getById(Long id);

}
