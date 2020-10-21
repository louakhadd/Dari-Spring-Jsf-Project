package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.FavoriteAd;

@Repository
public interface FavoriteAdRepository extends CrudRepository<FavoriteAd,Integer>{
	@Query(value="select * from t_favoritead where ad_id_ad=? AND id_client=?",nativeQuery=true)
	public FavoriteAd getFavoriteAd(int adId, long userId);
	
	
	
}
