package tn.esprit.spring.services;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.repository.ClientRepository;



@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentRepository AppointmentRepository;
	@Autowired
	ClientRepository ClientRepository;
	@Autowired
	ClientService cs;
	private static final Logger l= LogManager.getLogger(AppointmentServiceImpl.class);

	@Override
	public List<Appointment> retrieveAllAppointment() {
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
		for(Appointment appointment:app) {
			l.info("appointments +++++++++"+ appointment);}
		
		return app;
	}

	@Override
	public Appointment addAppointment(Appointment a,Date date) {
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();

		for(Appointment aa:app) {
			//Appointment aa=new Appointment();
		
		if (aa.getDateAppointement().compareTo(a.getDateAppointement()) > 0) {
			
			a.setState("confirmed");
			l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(a.getDateAppointement()) < 0) {
			a.setState("confirmed");
			l.info("appointment is22222222" + a.getState());

			
		}
		else {
			a.setState("not confirmed same date");

			l.info("appointment is333333333" + a.getState());

		}

	}
		AppointmentRepository.save(a);

		return a;
	}

	@Override
	public void deleteAppointment(String id) {
		
		AppointmentRepository.deleteById(Long.parseLong(id));		

		
	}

	@Override
	public Appointment retrieveAppointment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConfrmerAppointment(Date date) {
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();

		for(Appointment a:app) {
			//Appointment aa=new Appointment();
		
		if (a.getDateAppointement().compareTo(date) > 0) {
			
			a.setState("confirmed");
			l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(date) < 0) {
			a.setState("confirmed");
			l.info("appointment is22222222" + a.getState());

			
		}
		else {
			l.info("appointment is333333333" + a.getState());

		}
		AppointmentRepository.save(a);
		
		}
		
	}
/*
	@Override
	public int countAppointment() {
		int max=0;
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
		for(Appointment appointment:app) {
			max++;
			
		}
		l.info(" you have "+ max + "appointments");


		return max;

	}*/

	/*@Override
	public void RechercheConfirmedApp() {
		AppointmentRepository.retrieveAllAppointmentByState("confirmed");
		l.info("appointment is+++++++++++" + AppointmentRepository.retrieveAllAppointmentByState("confirmed"));

		
	}*/
	
	@Override
	public List<Appointment> rechercheAppointment() {
		List<Appointment> app=(List<Appointment>)AppointmentRepository.retrieveAllAppointmentByState("confirmed");
		for(Appointment appointment:app) {

		l.info("appointment is+++++++++++" + appointment);}
		return app;

		
	}

	@Override
	public void AppointmentToday() {
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
		int max=0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//Date da=new Date(dateFormat.format(date));
		l.info("********" + dateFormat.format(date));

		
	
		for(Appointment a:app) {
			//Appointment aa=new Appointment();
			
		if ((a.getDateAppointement().getDay()== date.getDay() ) && (a.getDateAppointement().getMonth()== date.getMonth()) && (a.getDateAppointement().getYear()== date.getYear())) {
			max++;
			
			l.info("********" + dateFormat.format(date)+a);
		}}
		l.info("you have "+max+" appointments today++++++++++++" );

		
	}
	@Override
	public void BlockUserByAttendance() {
		
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();

		for(Appointment a:app) {
			
					if(a.getAttendance().equals("absent") ) {
						
						//a.getClient().setBlock(true);
						AppointmentRepository.save(a);


						List<Client> cc=(List<Client>) ClientRepository.findAll();
						for(Client cli:cc) {
							AppointmentRepository.save(a);
							//ClientRepository.save(a.getClient());

						}
				
						//l.info("user is Blocked+++++++" + a.getClient().getId()+ "+++++++"+ a.getClient().isBlock());

	}
					}
	
	
	}
	
	
	
	
	/*
	@Override
	public void CancelApp(int adid)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Appointment app = AppointmentRepository.lastAppointment(adid);
		app.setPurchased(true);
		app.setDatePurchasing(date);
	
		AppointmentRepository.save(app);
	
	
		for (Appointment a : AppointmentRepository.findAll())
		{
			if(a.getIdannconce()==adid && a.isPurchased()==false)
			{
				a.setState("canceled");
				AppointmentRepository.save(a);
			}
		}
	}*/
	
	@Override
	public void CancelAppointment() {
		List<Appointment> app = (List<Appointment>) AppointmentRepository.findAll();
		List<Appointment> ap = (List<Appointment>) AppointmentRepository.retrieveAllAppointmentBypurchasing(false);

		// System.out.println("11111111111"+ap);}
/*
		int idd;
		for (Appointment a : app) {
			if (a.isPurchased()) {
				idd=a.getClient().getAd();
						//idd = a.getAd().getIdAd(); 
				for (Appointment aa : ap) {
					if (aa.getAd().getIdAd() == idd) {

						aa.setState("appointment is canceled this house has already purchased");
						l.info("++++++++" + aa.getState() + "++++++++++++++++++++");
						AppointmentRepository.save(aa);

					}
				}

			}

		}
*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
