package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.WishList;

public interface WishListService {
	WishList addWishList(WishList wl);
	void deleteWishList(int id); 
	WishList updateWishList(WishList wl); 
	List<WishList> retrieveAllWishLists();
	WishList retrieveWishList(String id);
	List<WishList> getAllWhishListsByUser(long clientId);
	Boolean comparaison(WishList wl, Ad ad);
	void NotifSms(Ad ad);
	
	///JSF//////
	int addOrUpdateWishList(WishList wl);

}
