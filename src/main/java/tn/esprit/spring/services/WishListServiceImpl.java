package tn.esprit.spring.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.WishListRepository;
import tn.esprit.spring.sms.SmsRequest;
import tn.esprit.spring.sms.SmsSender;

@Service
public class WishListServiceImpl implements WishListService{

	public static final Logger L = LogManager.getLogger(WishListServiceImpl.class);

	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	FavoriteAdService fs;
	@Autowired
	SmsSender ss;
	@Autowired
	UserService us;
	
	private final static String ACCOUNT_SID = "AC3516ef0735408cf3f34b1e53225667fa";
	private final static String AUTH_ID = "d7c9d7889b89693f030e4c9d1ababe48";

	
	@Override	
	public WishList addWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public void deleteWishList(int id) {
		// TODO Auto-generated method stub
		wishListRepository.delete(wishListRepository.findById(id).get());
	}

	@Override
	public WishList updateWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public List<WishList> retrieveAllWishLists() {
		// TODO Auto-generated method stub
		List<WishList> wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wl : wls) {
			L.info("whishlist +++"+wl);
		}
		return wls;
	}

	@Override
	public WishList retrieveWishList(String id) {
		// TODO Auto-generated method stub
		WishList u= wishListRepository.findById(Integer.parseInt(id)).orElse(null);
		L.info("retrive user by id ++++:"+u);
		return u;
				
	}
	
	@Override
	public List<WishList> getAllWhishListsByUser(long clientId) {
	//	Client clientManagedEntity = clientRepository.findById((long) clientId).get();
		
		User clientManagedEntity = us.findUserwithId(clientId);
		List<WishList> wls = new ArrayList<>();;
			
		wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wll : clientManagedEntity.getWishLists()) {
			L.info("whishlist +++"+wll);
		}
		return wls;		
	}

	
	 
	//kindofgood, ascenseur, sousol, nbPiece , Renting Type
	@Override
	public Boolean comparaison(WishList wl, Ad ad) {
		Boolean k = false;
		if(ad.getRentingtype()==null && wl.getTypeAnnonce()==null){		
			if (ad.getKindofgood().equals(wl.getKindofgood())  && ad.getPrice()>wl.getBudgetmin() && ad.getPrice()<wl.getBudgetmax() && ad.getArea()>wl.getAreamin()&& ad.getArea()<wl.getSurfacemax()
					&& ad.getNbRooms()== wl.getNbRooms() && ad.isGarden()== wl.isGarden() && ad.getNbGarage()==wl.getNbGarage() 
					&& ad.isSwimmingPool()==wl.isSwimmingPool()	&& ad.isTerrace()==wl.isTerrace() && ad.isAirConditioning()==wl.isAirConditioning() 
					&& ad.isHeater()==wl.isHeater() && ad.isFurnished()==wl.isFurnished() && ad.getLocation().equals(wl.getLocation())
					&& ad.getNbBaths()==wl.getNbBaths() && ad.isSousSol()==wl.isSousSol() && ad.isAscenseur()==wl.isAscenseur() ){
				k= true;
			}
		}
		else{
			if (ad.getRentperiod().equals(wl.getRentperiod()) && ad.getKindofgood().equals(wl.getKindofgood())  && ad.getPrice()>wl.getBudgetmin() && ad.getPrice()<wl.getBudgetmax() && ad.getArea()>wl.getAreamin()&& ad.getArea()<wl.getSurfacemax()
					&& ad.getNbRooms()== wl.getNbRooms() && ad.isGarden()== wl.isGarden() && ad.getNbGarage()==wl.getNbGarage() 
					&& ad.isSwimmingPool()==wl.isSwimmingPool()	&& ad.isTerrace()==wl.isTerrace() && ad.isAirConditioning()==wl.isAirConditioning()  
					&& ad.isHeater()==wl.isHeater() && ad.isFurnished()==wl.isFurnished() && ad.getLocation().equals(wl.getLocation())
					&& ad.getNbBaths()==wl.getNbBaths() && ad.isSousSol()==wl.isSousSol() && ad.isAscenseur()==wl.isAscenseur() 
					&& ad.getRentingtype().equals(wl.getTypeAnnonce())){
				k= true;
			}
		} 
		L.info("Alerte++++++++++:"+k);		
		
		return k;		
		}
	
		
	@Override
	public void NotifSms(Ad ad) {

		List<User> list= new ArrayList<>();
		List<User> list1= new ArrayList<>();
		
		for (WishList wl : wishListRepository.findAll()) {
			if (comparaison(wl, ad) == true && wl.isUrgent()==false){
				list.add(wl.getUser());
				L.info("UserSMS +++++++++++: " + wl.getUser());
			}		
			else{
				if (comparaison(wl, ad) == true && wl.isUrgent()==true){
					list1.add(wl.getUser());
					L.info("UserApp +++++++++++: " + wl.getUser());
				}
			}
		}	
		System.out.println("List loulaaaaaaaaaa"+list);
		System.out.println("List theniaaaaaaaaa"+list1);
		
		for(User client: list){
			SmsRequest smsRequest = new SmsRequest(client.getPhoneNumber(),"Une annonce conforme aux critères préenregistrés vient d'être poster! vous la retrouveré parmis vos favoris");
			ss.sendSms(smsRequest);
			
			fs.favoriserAnnonce(ad.getIdAd(), client.getId());
		}	
		for(User client: list1){
			Twilio.init(ACCOUNT_SID, AUTH_ID);
	        Call call = Call.creator(
	                new com.twilio.type.PhoneNumber("+21620752433"),
	                new com.twilio.type.PhoneNumber("+18509203338"),
	                URI.create("https://handler.twilio.com/twiml/EHd79f66f2b66ff4bf178f1742c929d0ce"))
	            .create();

			fs.favoriserAnnonce(ad.getIdAd(), client.getId());
		}	
	}
	
	
	
	
	///////////////JSF//////////////////////////////
	@Override
	public int addOrUpdateWishList(WishList wl) {
		wishListRepository.save(wl);
		return wl.getIdw();
	}
	
	
}
