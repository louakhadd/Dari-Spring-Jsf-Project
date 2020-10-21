package tn.esprit.spring.services;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RateEvent;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.repository.AdRepository;

@Named
@RequestScoped
	public class RatingView {
	     
	       
		private  Integer rating2;   
	    private Integer rating3;   
	    
	    @Autowired
		AdRepository adRepository;
	    @Autowired
		AdServiceImpl adservice;
	    
	    public void onrate(RateEvent rateEvent) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	     
	    public void oncancel() {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 
	 
	 
	   public Integer getRating8(int idad) {
			int k=0;
			
		List<Ad> ads=(List<Ad>)adRepository.findAll();
		
				for(Ad aa: ads) {
			 if(aa.getIdAd()==idad) {
			   
				   k=aa.getRating2();
				 
			     break;   
			 }
				}
				
				return k;
		     }

		public Integer getRating2() {
		return rating2;
	}

	public void setRating2(Integer rating2) {
		this.rating2 = rating2;
	}

		public Integer getRating3() {
			
			List<Ad> ads=(List<Ad>)adRepository.findAll();
			
			for(Ad aa: ads) {
			   rating3=aa.getRating();}
	        return rating3;
	    }
	 
	    public void setRating3(Integer rating3) {
	        this.rating3 = rating3;
	    }
	 
	
	  
	}

