package fr.mauritius.Backpacker.services;

import java.time.LocalDate;
import java.util.List;

import fr.mauritius.Backpacker.domain.dtos.CkbookingCreate;
import fr.mauritius.Backpacker.domain.dtos.CkbookingView;
import fr.mauritius.Backpacker.domain.entities.Ckbooking;

public interface CkbookingService {

    List<Ckbooking> listAllCkbooking();

    void create(CkbookingCreate dto);

    List<Ckbooking> getAllBetweenDates(LocalDate startDate, LocalDate endDate);

    CkbookingView getById(Long id);

    void Ckbooking(Long id);

//    void updateRoomid(Long id, CkbookingPatchR newRoom);

    // List<Ckbooking> getAllBetweenDates1(LocalDate startDate, LocalDate endDate,
    // Long roomId);

//    List<Ckbooking> getAllBetweenDates2(LocalDate startDate, LocalDate endDate, Long room_id);

}
