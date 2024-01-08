package emailFunction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emailFunction.entity.BookingAppointment;

public interface BookingRepository extends JpaRepository<BookingAppointment, Integer> {
    
	@Query(value="SELECT * FROM tbl_appointment e WHERE "+
            "STR_TO_DATE(e.appointment_date, '%Y-%m-%d') = CURDATE() AND"+
	  " TIMESTAMPDIFF(MINUTE,  STR_TO_DATE(SUBSTRING_INDEX(e.appointment_time, '-', 1), '%H:%i'),"+ 
	      " NOW()   ) = -331",nativeQuery = true)
	List<BookingAppointment> finByAppointmentDate();

	
	@Query (value="SELECT *FROM tbl_appointment e WHERE "+
			   " STR_TO_DATE(e.appointment_date, '%Y-%m-%d') = CURDATE() "+
			    "AND STR_TO_DATE(SUBSTRING_INDEX(e.appointment_time, '-', -1), '%H:%i') < NOW()",nativeQuery = true)
	List<BookingAppointment> findyByEndTime();

}
