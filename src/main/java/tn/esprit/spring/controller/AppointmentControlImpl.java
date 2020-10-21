package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.services.AppointmentService;

@RestController
public class AppointmentControlImpl {
	@Autowired
	AppointmentService AppointmentService;
	
	//http://localhost:8081/retrieve-all-appointment

	@GetMapping("/retrieve-all-appointment")
	 @ResponseBody
	 public List<Appointment> getAppointments() {
	 List<Appointment> list = AppointmentService.retrieveAllAppointment();
	 return list;
	} 
	
	// Ajouter User : http://localhost:8081/add-appointment
		  @PostMapping("/add-appointment")
		  @ResponseBody
		  public Appointment addAppointment(@RequestBody Appointment a,Date date) {
		  Appointment app = AppointmentService.addAppointment(a,date);
		 return app;
		  }
		  
		  //http://localhost:8081/remove-user/{user-id}
		  @DeleteMapping("/remove-user/{appointment-id}")
		   @ResponseBody
		   public void removeAppointment(@PathVariable("appointment-id") String id) {
		   AppointmentService.deleteAppointment(id);;
		   }
		  //http://localhost:8081/count
/*		  @GetMapping("/count")
		   @ResponseBody
		   public int CountAppointment() {
		   return AppointmentService.countAppointment();
		   }*/
		  
		//http://localhost:8081/recherche
		  @GetMapping("/recherche")
		   @ResponseBody
			 public List<Appointment> rechercheConfirmedAppointments() {
			  List<Appointment> list =AppointmentService.rechercheAppointment();
		return list;
		   }
		  
		//  : http://localhost:8081/BlockUser
		  @GetMapping("/BlockUser")
		  @ResponseBody
		  public void BlockUser() {
		  AppointmentService.BlockUserByAttendance();
		 
		  }
	

}
