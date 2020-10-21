package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_FAVORITEAD")
public class FavoriteAd {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdF;
	
	private long idClient;
	
	@OneToOne 
	private Ad ad;

	
	
	public int getIdF() {
		return IdF;
	}

	public void setIdF(int idF) {
		IdF = idF;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idC) {
		this.idClient = idC;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FavoriteAd [IdF=" + IdF + ", idClient=" + idClient + ", ad=" + ad + "]";
	}
	
	
	

}
