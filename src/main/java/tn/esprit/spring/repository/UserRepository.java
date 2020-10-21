package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;



public interface UserRepository extends CrudRepository<User, Long> {
	@Query(value="SELECT count(*) FROM USER",nativeQuery = true)
	public int retrieveUsers();
	@Query(value = "SELECT * FROM USER U inner JOIN follow f ON f.follow_id=:follow_id and U.id=f.followed_id ", nativeQuery = true)
	public List<User> MyFollow(@Param("follow_id") Long follow_id);
}
