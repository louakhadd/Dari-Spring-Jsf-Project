package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estimation")
public class PrixParM2 {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String ville;
	private float prixMaison;
	private float prixAppart;
	private float prixTerrain;
	private float minpMaison; 
	private float maxpMaison; 
	private float minpAppart; 
	private float maxpAppart;
	
	private float prixLoyerM;
	private float prixLoyerA;
	
	public PrixParM2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrixParM2(int id, String ville, float prixParM2Maison, float prixParM2Appart, float prixParM2NonConstruit) {
		super();
		Id = id;
		this.ville = ville;
		this.prixMaison = prixParM2Maison;
		this.prixAppart = prixParM2Appart;
		this.prixTerrain = prixParM2NonConstruit;
	}
	
	public PrixParM2(int id, String ville, float prixMaison, float prixAppart, float prixTerrain, float minpMaison,
			float maxpMaison, float minpAppart, float maxpAppart, float prixLoyerM, float prixLoyerA) {
		super();
		Id = id;
		this.ville = ville;
		this.prixMaison = prixMaison;
		this.prixAppart = prixAppart;
		this.prixTerrain = prixTerrain;
		this.minpMaison = minpMaison;
		this.maxpMaison = maxpMaison;
		this.minpAppart = minpAppart;
		this.maxpAppart = maxpAppart;
		this.prixLoyerM = prixLoyerM;
		this.prixLoyerA = prixLoyerA;
	}
	
	public PrixParM2(String ville, float prixMaison, float prixAppart, float minpMaison,
			float maxpMaison, float minpAppart, float maxpAppart) {
		super();
		this.ville = ville;
		this.prixMaison = prixMaison;
		this.prixAppart = prixAppart;
		this.minpMaison = minpMaison;
		this.maxpMaison = maxpMaison;
		this.minpAppart = minpAppart;
		this.maxpAppart = maxpAppart;
	}
	
	public PrixParM2(int id, String ville, float prixMaison, float prixAppart, float minpMaison, float maxpMaison,
			float minpAppart, float maxpAppart) {
		super();
		Id = id;
		this.ville = ville;
		this.prixMaison = prixMaison;
		this.prixAppart = prixAppart;
		this.minpMaison = minpMaison;
		this.maxpMaison = maxpMaison;
		this.minpAppart = minpAppart;
		this.maxpAppart = maxpAppart;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public float getPrixMaison() {
		return prixMaison;
	}
	public void setPrixMaison(float prixMaison) {
		this.prixMaison = prixMaison;
	}
	public float getPrixAppart() {
		return prixAppart;
	}
	public void setPrixAppart(float prixAppart) {
		this.prixAppart = prixAppart;
	}
	public float getPrixTerrain() {
		return prixTerrain;
	}
	public void setPrixTerrain(float prixTerrain) {
		this.prixTerrain = prixTerrain;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Estimation [Id=" + Id + ", ville=" + ville + ", prixParM2Maison=" + prixMaison
				+ ", prixParM2Appart=" + prixAppart + ", prixParM2NonConstruit=" + prixTerrain + "]";
	}
	public float getMinpMaison() {
		return minpMaison;
	}
	public void setMinpMaison(float minpMaison) {
		this.minpMaison = minpMaison;
	}
	public float getMaxpMaison() {
		return maxpMaison;
	}
	public void setMaxpMaison(float maxpMaison) {
		this.maxpMaison = maxpMaison;
	}
	public float getMinpAppart() {
		return minpAppart;
	}
	public void setMinpAppart(float minpAppart) {
		this.minpAppart = minpAppart;
	}
	public float getMaxpAppart() {
		return maxpAppart;
	}
	public void setMaxpAppart(float maxpAppart) {
		this.maxpAppart = maxpAppart;
	}
	public float getPrixLoyerM() {
		return prixLoyerM;
	}
	public void setPrixLoyerM(float prixLoyerM) {
		this.prixLoyerM = prixLoyerM;
	}
	public float getPrixLoyerA() {
		return prixLoyerA;
	}
	public void setPrixLoyerA(float prixLoyerA) {
		this.prixLoyerA = prixLoyerA;
	}
	
	
	 

}
