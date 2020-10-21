package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.EstimationAvis;


@Repository
public interface EstimationAvisRepository extends CrudRepository<EstimationAvis,Integer>{
	
	@Query(value="SELECT good FROM estimation_avis where id=1",nativeQuery=true)
	public int getGoodOpinion();

	@Query(value="SELECT low FROM estimation_avis where id=1",nativeQuery=true)
	public int getLowOpinion();
	
	@Query(value="SELECT high FROM estimation_avis where id=1",nativeQuery=true)
	public int getHighOpinion();
}
