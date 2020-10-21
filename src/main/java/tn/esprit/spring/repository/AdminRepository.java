package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Admin;



public interface AdminRepository extends CrudRepository<Admin,Long> {

	
}
