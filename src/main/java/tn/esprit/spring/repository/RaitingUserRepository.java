package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.raitingUser;

public interface RaitingUserRepository extends CrudRepository<raitingUser, Integer> {
	@Modifying
	@Transactional
	@Query(
	  value = "INSERT INTO `raiting_user` (`id`, `nbretoile`, `user_connecte_id`, `user_rate_id`) VALUES (NULL, :nbretoile, :user_connecte_id,:user_rate_id);",nativeQuery = true)
	void Insertrate(@Param("nbretoile") int nbretoile, @Param("user_connecte_id") Long user_connecte_id, @Param("user_rate_id") Long user_rate_id);
	
	
	@Transactional
	@Query(value="SELECT * FROM `raiting_user` WHERE `user_connecte_id` =:user_connecte_id AND `user_rate_id` =:user_rate_id LIMIT 1  ",nativeQuery = true)
	public raitingUser findRaiting(@Param("user_connecte_id") Long user_connecte_id,@Param("user_rate_id") Long user_rate_id);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE `raiting_user` SET `nbretoile` =':nbretoile' WHERE `raiting_user`.`id` =:raiting_user",nativeQuery = true)
	public Long updateraiting(@Param("nbretoile") int nbretoile,@Param("raiting_user") int raiting_user);
	
	
	@Transactional
	@Query(value="SELECT * FROM `raiting_user` WHERE `user_rate_id` =:user_rate_id ",nativeQuery = true)
	public List<raitingUser> findRaitingwithConnctUser(@Param("user_rate_id") Long user_rate_id);

}
