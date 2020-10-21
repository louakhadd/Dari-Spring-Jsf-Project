package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Appointment;


public interface AppointmentService {
	List<Appointment> retrieveAllAppointment();
	Appointment addAppointment(Appointment a,Date date);

	void deleteAppointment(String id);
	Appointment retrieveAppointment(String id);
	void ConfrmerAppointment(Date date);
//	int countAppointment();
	//void RechercheConfirmedApp();
	public List<Appointment> rechercheAppointment();
	public void AppointmentToday();
	public void BlockUserByAttendance();

	
	
	public void CancelAppointment();
//	public void CancelApp(int adid);
	
}
