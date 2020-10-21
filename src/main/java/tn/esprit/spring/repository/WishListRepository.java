package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.WishList;

@Repository
public interface WishListRepository extends CrudRepository<WishList,Integer>{

}
