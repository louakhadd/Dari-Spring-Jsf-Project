package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.PrixParM2;

public interface PrixParM2Repository extends CrudRepository<PrixParM2, Integer>{
	
	@Query(value="select prix_appart from estimation where ville=? ",nativeQuery=true)
	public float PrixAppart(String Ville);	
	
	@Query(value="select minp_appart from estimation where ville=? ",nativeQuery=true)
	public float PrixMinAppart(String Ville);	
	
	@Query(value="select maxp_appart from estimation where ville=? ",nativeQuery=true)
	public float PrixMaxAppart(String Ville);	

	@Query(value="select prix_maison from estimation where ville=? ",nativeQuery=true)
	public float PrixMaison(String Ville);
	
	@Query(value="select minp_maison from estimation where ville=? ",nativeQuery=true)
	public float PrixMinMaison(String Ville);
	
	@Query(value="select maxp_maison from estimation where ville=? ",nativeQuery=true)
	public float PrixMaxMaison(String Ville);
	
	@Query(value="select prix_terrain from estimation where ville=? ",nativeQuery=true)
	public float PrixTerrain(String Ville);
	
	/////les loyer
	@Query(value="select prix_loyera from estimation where ville=? ",nativeQuery=true)
	public float PrixLoyerAppart(String Ville);	
	
	@Query(value="select prix_loyerm from estimation where ville=? ",nativeQuery=true)
	public float PrixLoyerMaison(String Ville);	
	
	
	
}

