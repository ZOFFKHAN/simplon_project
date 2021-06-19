package fr.mauritius.Backpacker.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.mauritius.Backpacker.domain.dtos.CkbookingCreate;
import fr.mauritius.Backpacker.domain.dtos.CkbookingView;
import fr.mauritius.Backpacker.domain.entities.Ckbooking;
import fr.mauritius.Backpacker.domain.entities.Customer;
import fr.mauritius.Backpacker.domain.entities.Room;
import fr.mauritius.Backpacker.repositories.CkbookingRepository;
import fr.mauritius.Backpacker.repositories.CustomerRepository;
import fr.mauritius.Backpacker.repositories.RoomRepository;

@Service
public class CkbookingServiceImpl implements CkbookingService {

    // @Override

    private final CkbookingRepository ckbookings;
    private final CustomerRepository customerRepo;
    private final RoomRepository roomRepo;

    public CkbookingServiceImpl(CkbookingRepository ckbookings, CustomerRepository customerRepo,
	    RoomRepository roomRepo) {

	this.ckbookings = ckbookings;
	this.customerRepo = customerRepo;
	this.roomRepo = roomRepo;
    }

    public List<Ckbooking> listAllCkbooking() {
	return ckbookings.findAll();

    }

    @Override
    public CkbookingView getById(Long id) {
	Ckbooking ckbooking = ckbookings.getById(id).get();
	CkbookingView view = new CkbookingView();
	view.setId(id);
	view.setCkid(ckbooking.getCkid());
	view.setDateBegin(ckbooking.getDateBegin());
	view.setDateEnd(ckbooking.getDateEnd());

	view.setIsloaded(ckbooking.isIsloaded());
	// view.setRoomId(ckbooking.getRoomId());
	view.setMainRoomId(ckbooking.getMainRoom().getId());
	view.setMainCustomerId(ckbooking.getMainCustomer().getId());

	Customer customer = customerRepo.getOne(ckbooking.getMainCustomer().getId());
	ckbooking.setMainCustomer(customer);

	System.out.println(customer);

	view.setUsermail(customer.getEmail());

	System.out.println("test id");
	System.out.println(view.getMainCustomerId());
	System.out.println(id);

//	Customer customer = customerRepo.getOne(view.getMainCustomerId());
//	ckbooking.setMainCustomer(customer);

	return view;
    }

    @Override
    public void create(CkbookingCreate dto) {
	System.out.println("call in service");
	Ckbooking ckbooking = new Ckbooking();
	ckbooking.setCkid(dto.getCkid());

	ckbooking.setDateBegin(dto.getDateBegin());
	ckbooking.setDateEnd(dto.getDateEnd());
	// ckbooking.setRoomId(dto.getRoomId());
	ckbooking.setIsloaded(false);

	Long mainRoomId = dto.getMainRoomId();
	Room room = roomRepo.getOne(mainRoomId);
	ckbooking.setMainRoom(room);

	Long mainCustomerId = dto.getMainCustomerId();
	Customer customer = customerRepo.getOne(mainCustomerId);
	ckbooking.setMainCustomer(customer);

	ckbookings.save(ckbooking);

    }

    @Override
    public List<Ckbooking> getAllBetweenDates(LocalDate startDate, LocalDate endDate) {

	return ckbookings.getAllBetweenDates(startDate, endDate);

    }

    @Override
    public void Ckbooking(Long id) {

	ckbookings.deleteByid(id);

    }

//    @Override
//    public void updateRoomid(Long id, CkbookingPatchR newRoom) {
//	// TODO Auto-generated method stub
//	Ckbooking ckbooking = ckbookings.getByid(id).get();
////	ckbooking.setRoomId(newRoom.getRoomId());
//
//	ckbookings.save(ckbooking);
//    }

//    @Override
//    public List<Ckbooking> getAllBetweenDates1(LocalDate startDate, LocalDate endDate, Long roomId) {
//	// TODO Auto-generated method stub
//
//	// Over lap exists
//
//	return ckbookings.getAllBetweenDates1(startDate, endDate, roomId);
//    }

//    @Override
//    public List<Ckbooking> getAllBetweenDates2(LocalDate startDate, LocalDate endDate, Long room_id) {
//	// TODO Auto-generated method stub
//
//	return ckbookings.getAllBetweenDates2(startDate, endDate, room_id);
//    }

}
