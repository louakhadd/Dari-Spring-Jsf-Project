package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.FavoriteAd;
import tn.esprit.spring.entities.Prices;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FavoriteAdRepository;
import tn.esprit.spring.repository.PricesRepository;
import tn.esprit.spring.sms.SmsRequest;
import tn.esprit.spring.sms.SmsSender;

@Service
public class FavoriteAdServiceImpl implements FavoriteAdService{

	public static final Logger L = LogManager.getLogger(FavoriteAdServiceImpl.class);

	
	@Autowired
	FavoriteAdRepository favoriteAdRepository;
	@Autowired
	ClientRepository clientRepository;	
	@Autowired
	AdRepository adRepository;
	@Autowired
	PricesRepository pricesRepository;	
	@Autowired
	IAdService sa;
	@Autowired
	ClientService cs;
	@Autowired
	SmsSender ss; 
	@Autowired
	PricesRepository pr;
	@Autowired
	UserService us;
	
	@Override
	public void favoriserAnnonce(int adId, long idC){
		if(favoriteAdRepository.getFavoriteAd(adId, idC)==null)
		{
			FavoriteAd fav = new FavoriteAd();
			Ad ad = adRepository.findById(adId).get();
			fav.setAd(ad);
			fav.setIdClient(idC);
			favoriteAdRepository.save(fav);
			
		}
		else
		{
			L.info("aaaaaaaaaaaaaaa");
		}
		
	}		

	@Override
	public void deleteFavorite(int id) {
		// TODO Auto-generated method stub
		favoriteAdRepository.delete(favoriteAdRepository.findById(id).get());
	}

///// ces 2 fct à modifier
	@Override
	public List<FavoriteAd> retrieveAllFavorites() {
		// TODO Auto-generated method stub
		List<FavoriteAd> f=(List<FavoriteAd>)favoriteAdRepository.findAll();
		for (FavoriteAd fa : f) {
			L.info("favoriteAd +++"+fa);
		}
		return f;
	}  

	@Override
	public FavoriteAd retrieveFavorite(String id) {
		// TODO Auto-generated method stub
		FavoriteAd f= favoriteAdRepository.findById(Integer.parseInt(id)).orElse(null);
		//Ad a = sa.retrieveadById(id);
		L.info("retrive wishList by id ++++:"+f);
		return f;
				
	}
	
	
	@Override
	public List<Ad> getAllFavoritesByClient(long clientId) {
		User clientManagedEntity =us.findUserwithId(clientId);
		
		List<FavoriteAd> wls = new ArrayList<>();
		List<Ad> adfav = new ArrayList<>();
			
		wls=(List<FavoriteAd>)favoriteAdRepository.findAll();
		for (FavoriteAd wll : wls) {
			if(wll.getIdClient() == clientId)
			{
				adfav.add(wll.getAd());
			}
			else {L.info("Favoriiiit+++++++++"+false);}
		}
		
		L.info("Favoriiiit+++++++++"+adfav);
		
		return adfav;		
	}

////////////////////////////////////////////////////
	
	@Override
	public Prices PricesAdd(Ad ad) {
		// TODO Auto-generated method stub
		Prices p = new Prices();
		p.setAd(ad);
		p.setPrice(ad.getPrice());
		
		return pricesRepository.save(p);
	}
	
	
	
	@Override
	public  void changementPrix(Ad ad)
	{
		List<Client> listclient= new ArrayList<>();
		List<Prices> list= (List<Prices>)pricesRepository.findAll();
		float a=0;
		
		//recherche dans la table des prix
		for (Prices p : list)
		{
			if(p.getAd().getIdAd()==ad.getIdAd())
			{
				a = pr.getPricesByAdId(1);
				L.info("pppppppppppp"+a);
				p.setPrice(ad.getPrice());
				L.info("pppppppppppp"+ p.getPrice());
			}
		}
		
		//recherche des clients qui ont favoriser cette annonce
		for (FavoriteAd fav : retrieveAllFavorites())
		{
			if(fav.getAd().getIdAd()==ad.getIdAd())
			{
				listclient.add(cs.retrieveClient(String.valueOf(fav.getIdClient())));
			}
			L.info("eeeeeeeeeeeeeeeeee"+listclient);
		}
		
		//tester les prix
		for(Client client: listclient)
		{
			if (a<ad.getPrice())
			{
				SmsRequest smsRequest = new SmsRequest(client.getPhoneNumber(),"Le prix de l'une de vos annonces favorite vient d'augmenter");
				ss.sendSms(smsRequest);
			}
			else if (a>ad.getPrice())
			{
				SmsRequest smsRequest = new SmsRequest(client.getPhoneNumber(),"Le prix de l'une de vos annonces favorite a baissé");
				ss.sendSms(smsRequest);
			}
		}  
		
				
	} 
	

	
	
	
	
	

}
