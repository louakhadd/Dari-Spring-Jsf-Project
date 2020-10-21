package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.FavoriteAd;
import tn.esprit.spring.entities.Prices;

public interface FavoriteAdService {
	void favoriserAnnonce(int adId, long idC);
	void deleteFavorite(int id); 
	List<FavoriteAd> retrieveAllFavorites();
	FavoriteAd retrieveFavorite(String id);
    List<Ad> getAllFavoritesByClient(long clientId);
    Prices PricesAdd(Ad ad);
    void changementPrix(Ad ad);
}
