package fr.mauritius.Backpacker.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.mauritius.Backpacker.domain.entities.Ckbooking;

public interface CkbookingRepository extends JpaRepository<Ckbooking, Long> {

    Object overlappingRecords = null;

    Optional<Ckbooking> getById(Long id);

    @Query(value = "from Ckbooking c where  (c.dateBegin between :startDate and :endDate OR  :startDate between dateBegin and dateEnd )")
    List<Ckbooking> getAllBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    // TODO Auto-generated method stub

    // void deleteById(Long id);

    boolean existsByckid(String value);

    @Query(value = "from Ckbooking c where roomid = :roomId AND ((c.dateBegin<= :endDate AND dateEnd >= :startDate)\r\n"
	    + "  OR (c.dateBegin>= :endDate AND c.dateBegin<= :startDate AND dateEnd <= :startDate)\r\n"
	    + "  OR (dateEnd <= :startDate AND dateEnd >= :endDate AND c.dateBegin <= :endDate)\r\n"
	    + "  OR (c.dateBegin>= :endDate AND c.dateBegin<= :startDate))")
    List<Ckbooking> overlappingRecords(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
	    @Param("roomId") Long roomId);

//    @Query(value = "from Ckbooking c where roomid = :roomId AND (c.dateBegin between :startDate and :endDate OR  :startDate between dateBegin and dateEnd )")
//    List<Ckbooking> overlappingRecords(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
//	    @Param("roomId") Long roomId);

    @Query(value = "from Ckbooking c where roomid = :roomId AND (c.dateBegin between :startDate and :endDate OR  :startDate between dateBegin and dateEnd )")
    List<Ckbooking> getAllBetweenDates1(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
	    @Param("roomId") Long roomId);

//    @Query(value = "from Ckbooking c where c.roomId = :roomId AND (c.dateBegin between :startDate and :endDate OR  :startDate between Date_Begin and dateEnd )")
//    List<Ckbooking> getAllBetweenDates1(@Param("startstaDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
//	    @Param("roomId") Long roomId);

//    @Query("from Ckbooking o where o.roomId = ?3 and (o.dateBegin between ?1 and ?2) "
//	    + "or (o.dateEnd between ?1 and ?2)")
//    List<Ckbooking> getAllBetweenDates2(LocalDate startDate, LocalDate endDate, Long roomId);

}
