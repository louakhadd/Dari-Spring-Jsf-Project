package tn.esprit.spring.services;



public interface RaitingUserService {

	public String addRate(String IDConnecte, String IdRate,int nbretoile);
	public String moyenneRaiting(String IDConnecte);

}
