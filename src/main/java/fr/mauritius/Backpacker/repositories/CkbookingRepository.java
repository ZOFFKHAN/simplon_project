package fr.mauritius.Backpacker.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.mauritius.Backpacker.domain.entities.Ckbooking;

public interface CkbookingRepository extends JpaRepository<Ckbooking, Long> {

    Optional<Ckbooking> getById(Long id);

    @Query(value = "from Ckbooking c where (c.DateBegin between :startDate and :endDate OR c.DateEnd between :startDate and :endDate)")
    List<Ckbooking> getAllBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    // TODO Auto-generated method stub

    void deleteByid(Long id);

//    @Query(value = "from Ckbooking c where c.roomId = :roomId AND (c.DateBegin between :startDate and :endDate OR  :startDate between Date_Begin and DateEnd )")
//    List<Ckbooking> getAllBetweenDates1(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
//	    @Param("roomId") Long roomId);

//    @Query("from Ckbooking o where o.roomId = ?3 and (o.DateBegin between ?1 and ?2) "
//	    + "or (o.DateEnd between ?1 and ?2)")
//    List<Ckbooking> getAllBetweenDates2(LocalDate startDate, LocalDate endDate, Long roomId);

}
