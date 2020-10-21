package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.FavoriteAd;


public interface AppointmentRepository extends CrudRepository<Appointment,Long>{
	@Query("SELECT a FROM Appointment a WHERE a.state=:confirmed ")
	List<Appointment> retrieveAllAppointmentByState(@Param("confirmed")String State);
	
	@Query("SELECT c FROM Appointment c Where c.DatePurchasing is NULL")
	List<Appointment> AppointmentByDatePurchasingNull(@Param("NULL")Date DatePurchasing);
	
	@Query("SELECT a FROM Appointment a WHERE a.purchased=:false  ")
	List<Appointment> retrieveAllAppointmentBypurchasing(@Param("false")boolean purchased);

	
	//mine also
    @Query(value="SELECT * FROM appointment WHERE date_appointement=(SELECT MAX(date_appointement)FROM appointment) AND ad_id_ad=?",nativeQuery=true)
   	public Appointment lastAppointment(int adId);
    
    
    //loua
    @Query(value="SELECT * FROM Appointment WHERE purchased=true ORDER BY date_purchasing DESC",nativeQuery=true)
	public List<Appointment> getpurchased();
}
