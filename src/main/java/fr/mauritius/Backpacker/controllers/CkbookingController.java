package fr.mauritius.Backpacker.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mauritius.Backpacker.domain.dtos.CkbookingCreate;
import fr.mauritius.Backpacker.domain.dtos.CkbookingView;
import fr.mauritius.Backpacker.domain.entities.Ckbooking;
import fr.mauritius.Backpacker.services.CkbookingService;

@RestController
@RequestMapping("/ckbookings")
@Secured({ "ROLE_ADMIN", "ROLE_BASIC" })

public class CkbookingController {
    private final CkbookingService service;

    public CkbookingController(CkbookingService service) {
	this.service = service;
    }

    @GetMapping("")
    public List<Ckbooking> list() {
	return service.listAllCkbooking();
    }

    @GetMapping("/{id}")
    public CkbookingView getById(@PathVariable("id") Long id) {
	return service.getById(id);

    }

    @PostMapping

    public void create(@RequestBody @Valid CkbookingCreate dto) {
	// public void create(@RequestBody CkbookingCreate dto) {
	service.create(dto);
	System.out.println(dto);
    }

    @GetMapping("/fetch1/{one_date}/{two_date}")
    public List<Ckbooking> getAllBetweenDates(
	    @PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	    @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
	return service.getAllBetweenDates(startDate, endDate);

    }

    @GetMapping("/fetch1/{one_date}/{two_date}/{roomId}")
    public List<Ckbooking> getAllBetweenDates1(
	    @PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	    @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
	    @PathVariable(value = "roomId") Long roomId) {

	return service.getAllBetweenDates1(startDate, endDate, roomId);

    }

    @Secured({ "ROLE_ADMIN" })

    @DeleteMapping("/{id}")
    public void deleteCkbooking(@PathVariable("id") Long id) {
	service.deleteCkbooking(id);

    }

//    @PatchMapping("/{id}/change-room")
//    public void updateRoomid(@PathVariable("id") Long id, @RequestBody CkbookingPatchR NewRoom) {
//	service.updateRoomid(id, NewRoom);
//
//    }

}
