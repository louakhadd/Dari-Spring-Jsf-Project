package tn.esprit.spring.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client  extends User  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	private String picture;
	private boolean block;
	private String DescriptionBlock;
	private int nbre;
	

	public int getNbre() {
		return nbre;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", picture=" + picture + ", block=" + block + ", DescriptionBlock="
				+ DescriptionBlock + "]";
	}
	public Client( String firstName, String email,String password) {
		super(firstName,email,password);
		
	}
	
	public Client() {
		super();
	}
	public Client(Long id, String picture,/* boolean block,*/ String descriptionBlock) {
		super();
		this.id = id;
		this.picture = picture;
		//this.block = block;
		DescriptionBlock = descriptionBlock;
	}

	public String getDescriptionBlock() {
		return DescriptionBlock;
	}
	public void setDescriptionBlock(String descriptionBlock) {
		DescriptionBlock = descriptionBlock;
	}
	
	
	
	

}