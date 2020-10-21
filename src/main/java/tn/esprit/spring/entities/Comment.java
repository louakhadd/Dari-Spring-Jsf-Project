package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "T_COMMENT")
public class Comment implements Serializable{

			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int IdComment;
			
			private String DescriptionComment;
			private int NumberLikes;
			
			private Boolean IsBlocked;
		
			@ManyToOne
			private Client client;
		
			@ManyToOne
			private Ad Ads;
			
		
			public int getIdComment() {
				return IdComment;
			}
			public Ad getAds() {
				return Ads;
			}

			
			public void setAds(Ad ads) {
				Ads = ads;
			}
			public void setIdComment(int idComment) {
				IdComment = idComment;
			}

			public String getDescriptionComment() {
				return DescriptionComment;
			}

			public void setDescriptionComment(String descriptionComment) {
				DescriptionComment = descriptionComment;
			}

			public int getNumberLikes() {
				return NumberLikes;
			}

			public void setNumberLikes(int numberLikes) {
				NumberLikes = numberLikes;
			}

			public Boolean getIsBlocked() {
				return IsBlocked;
			}
			

			public void setIsBlocked(Boolean isBlocked) {
				IsBlocked = isBlocked;
			}


			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			public Comment() {
				super();
				// TODO Auto-generated constructor stub
			}
	
			
			public Comment(String descriptionComment, int numberLikes, Client client, Ad ads,Boolean isBlocked) {
				super();
				DescriptionComment = descriptionComment;
				NumberLikes = numberLikes;
				this.client = client;
				Ads = ads;
				IsBlocked = isBlocked;
			}

			public Comment( String descriptionComment) {
			
				DescriptionComment = descriptionComment;
				
			}
			

			public Comment(int idComment, String descriptionComment,  Client client, Ad ads) {
				super();
				IdComment = idComment;
				DescriptionComment = descriptionComment;
				this.client = client;
				Ads = ads;
			}


			public Client getClient() {
				return client;
			}

			public void setClient(Client client) {
				this.client = client;
			}

		

			
		
			

}
