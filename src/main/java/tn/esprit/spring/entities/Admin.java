package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Admin extends User{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	private String picture;
	private String UserName;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(Long id, String firstName, String lastname, Date dateNaissance, String email, String password) {
		super(id, firstName, lastname, dateNaissance, email, password);
		// TODO Auto-generated constructor stub
	}
	public Admin(Long id, String firstName, String lastname, Date dateNaissance, String email, String password,
			Long id2, String picture, String userName) {
		super(id, firstName, lastname, dateNaissance, email, password);
		id = id2;
		this.picture = picture;
		UserName = userName;
	}
	

}
