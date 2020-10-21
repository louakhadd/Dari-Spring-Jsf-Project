package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.RentPeriod;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PricesRepository;
import tn.esprit.spring.repository.PrixParM2Repository;
import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.AppointmentService;
import tn.esprit.spring.services.ClientService;
import tn.esprit.spring.services.FavoriteAdService;
import tn.esprit.spring.services.IAdService;
import tn.esprit.spring.services.UserService;
import tn.esprit.spring.services.WishListService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DariSpringBootApplicationTests {

	
	@Test
	public void contextLoads() throws ParseException {
		
	}

}