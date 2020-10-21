package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EstimationAvis")
public class EstimationAvis implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;

	private int High;
	private int good;
	private int low;

	
	public int getHigh() {
		return High;
	}
	public void setHigh(int high) {
		High = high;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
