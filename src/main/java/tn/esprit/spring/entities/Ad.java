package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_AD")


public class Ad implements Serializable{
		private static final long serialVersionUID = 1L;
        
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int IdAd;
		
		private String Description;
		private String image;
		private int nbLikes;
		private int nbDisLikes;
		private String Location;
		private int Area;
		@Column(name = "rating", nullable = true)
		private Integer rating;
		@Column(name = "rating2", nullable = true)
		private Integer rating2;
		@Column()
		@Enumerated(EnumType.STRING)
		private Etat etat;
		@Temporal(TemporalType.DATE)
		private Date AdDate;
		@Column(name = "ViewsNumber", nullable = true)

		private int ViewsNumber;
		
		private Boolean Success;
		@Column(name = "Score", nullable = true)
		private int Score;
		
		@Enumerated(EnumType.STRING)
		//@NotNull
		private KindOfGood kindofgood;
		
		@OneToMany(mappedBy = "Ads",fetch = FetchType.EAGER)
		private List<Comment> comments = new ArrayList<>();

		@ManyToOne
		private User user;
		
		@Temporal(TemporalType.DATE)
		private Date StartDate;
		
		@Temporal(TemporalType.DATE)
		private Date EndDate;
		
		@Enumerated(EnumType.STRING)
		//@NotNull
		private RentPeriod rentperiod;
		@Column(name = "Price", nullable = true)
		private float Price;
		@Enumerated(EnumType.STRING)
		//@NotNull
		private RentingType rentingtype;
	
	
//louu
		private int nbBaths;
		private int nbRooms;
		private int nbGarage;
		//options
		private boolean Terrace;
	
		private boolean SwimmingPool;
	
		private boolean Garden;	
		private boolean AirConditioning;
		private boolean heater;
		public boolean SousSol;		
		private boolean ascenseur;
		
		private boolean Furnished;// cet attribut uniquement pour les annonce de location c'est à dire meublé ou nn
		@OneToOne(mappedBy="ad") 
		FavoriteAd favoriteAd; 

		@OneToOne(cascade = CascadeType.ALL,mappedBy="ad") 
		Prices price;
		
		private long idAcheteur;
		
		private String garantie;
		@Temporal(TemporalType.DATE)
		private Date dateAchat;

		public Ad() {
			super();
			
		}


		public Ad(String description, String location, int area, Date adDate,KindOfGood kindofgood) {
			super();
			Description = description;
			Location = location;
			Area = area;
			AdDate = adDate;
			this.kindofgood = kindofgood;
		}
		

	
		
		public Ad(int idAd, String description, String location, int area, Date adDate,
				KindOfGood kindofgood, Date startDate, Date endDate, RentPeriod rentperiod, float price,
				RentingType rentingtype,String image) {
			super();
			IdAd = idAd;
			Description = description;
			Location = location;
			Area = area;
			AdDate = adDate;
			this.kindofgood = kindofgood;
			StartDate = startDate;
			EndDate = endDate;
			this.rentperiod = rentperiod;
			Price = price;
			this.rentingtype = rentingtype;
			image = image;
		}


		public Ad(String description, String location, int area, KindOfGood kindofgood, Date startDate, Date endDate,
				RentPeriod rentperiod,  RentingType rentingtype) {
			super();
			Description = description;
			Location = location;
			Area = area;
			this.kindofgood = kindofgood;
			StartDate = startDate;
			EndDate = endDate;
			this.rentperiod = rentperiod;		
			this.rentingtype = rentingtype;
		}


		

		public Ad(String description, String location, int area, KindOfGood kindofgood, Date startDate, Date endDate,
				RentPeriod rentperiod, float price, RentingType rentingtype) {
			super();
			Description = description;
			Location = location;
			Area = area;
			this.kindofgood = kindofgood;
			StartDate = startDate;
			EndDate = endDate;
			this.rentperiod = rentperiod;
			Price = price;
			this.rentingtype = rentingtype;
		}


		public int getIdAd() {
			return IdAd;
		}

		public void setIdAd(int idAd) {
			IdAd = idAd;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String location) {
			Location = location;
		}

		

		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public int getArea() {
			return Area;
		}


		public void setArea(int area) {
			Area = area;
		}

		@PrePersist
		protected void onCreate() {
		    if (AdDate== null) { AdDate= new Date(); }
		}
		public Date getAdDate() {
			return AdDate;
		}

		public void setAdDate(Date adDate) {
			AdDate = adDate;
		}

		public int getViewsNumber() {
			return ViewsNumber;
		}

		public void setViewsNumber(int viewsNumber) {
			ViewsNumber = viewsNumber;
		}

		public int getNbLikes() {
			return nbLikes;
		}


		public void setNbLikes(int nbLikes) {
			this.nbLikes = nbLikes;
		}


		public int getNbDisLikes() {
			return nbDisLikes;
		}


		public void setNbDisLikes(int nbDisLikes) {
			this.nbDisLikes = nbDisLikes;
		}


		public Boolean getSuccess() {
			return Success;
		}

		public void setSuccess(Boolean success) {
			Success = success;
		}

		public int getScore() {
			return Score;
		}

		public void setScore(int score) {
			Score = score;
		}


		public KindOfGood getKindofgood() {
			return kindofgood;
		}


		public void setKindofgood(KindOfGood kindofgood) {
			this.kindofgood = kindofgood;
		}


		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}


		public Integer getRating2() {
			return rating2;
		}


		public void setRating2(Integer rating2) {
			this.rating2 = rating2;
		}


		public Date getStartDate() {
			return StartDate;
		}


		public void setStartDate(Date startDate) {
			StartDate = startDate;
		}


		public Date getEndDate() {
			return EndDate;
		}


		public void setEndDate(Date endDate) {
			EndDate = endDate;
		}


		public RentPeriod getRentperiod() {
			return rentperiod;
		}


		public void setRentperiod(RentPeriod rentperiod) {
			this.rentperiod = rentperiod;
		}


		public float getPrice() {
			return Price;
		}


		public void setPrice(float price) {
			Price = price;
		}


		public RentingType getRentingtype() {
			return rentingtype;
		}


		public void setRentingtype(RentingType rentingtype) {
			this.rentingtype = rentingtype;
		}


	

		public Integer getRating() {
			return rating;
		}


		public void setRating(Integer rating) {
			this.rating = rating;
		}


		public String getImage() {
			return image;
		}


		public void setImage(String image) {
			image = image;
		}


		public int getNbRooms() {
			return nbRooms;
		}

		public int getNbBaths() {
			return nbBaths;
		}


		public void setNbBaths(int nbBaths) {
			this.nbBaths = nbBaths;
		}

		public void setNbRooms(int nbRooms) {
			this.nbRooms = nbRooms;
		}

		public int getNbGarage() {
			return nbGarage;
		}


		public void setNbGarage(int nbGarage) {
			this.nbGarage = nbGarage;
		}

		public FavoriteAd getFavoriteAd() {
			return favoriteAd;
		}


		public void setFavoriteAd(FavoriteAd favoriteAd) {
			this.favoriteAd = favoriteAd;
		}


		public void setPrice(Prices price) {
			this.price = price;
		}

		public boolean isTerrace() {
			return Terrace;
		}


		public void setTerrace(boolean terrace) {
			Terrace = terrace;
		}


		public boolean isSwimmingPool() {
			return SwimmingPool;
		}


		public void setSwimmingPool(boolean swimmingPool) {
			SwimmingPool = swimmingPool;
		}


		public boolean isGarden() {
			return Garden;
		}


		public void setGarden(boolean garden) {
			Garden = garden;
		}


		public boolean isAirConditioning() {
			return AirConditioning;
		}


		public void setAirConditioning(boolean airConditioning) {
			AirConditioning = airConditioning;
		}


		public boolean isHeater() {
			return heater;
		}


		public void setHeater(boolean heater) {
			this.heater = heater;
		}


		public boolean isSousSol() {
			return SousSol;
		}


		public void setSousSol(boolean sousSol) {
			SousSol = sousSol;
		}


		public boolean isAscenseur() {
			return ascenseur;
		}


		public void setAscenseur(boolean ascenseur) {
			this.ascenseur = ascenseur;
		}


		public boolean isFurnished() {
			return Furnished;
		}


		public void setFurnished(boolean furnished) {
			Furnished = furnished;
		}


		@Override
		public String toString() {
			return "Ad [IdAd=" + IdAd + ", Description=" + Description + ", Image=" + image + ", Location=" + Location
					+ ", Area=" + Area + ", rating=" + rating + ", rating2=" + rating2 + ", AdDate=" + AdDate
					+ ", ViewsNumber=" + ViewsNumber + ", Success=" + Success + ", Score=" + Score + ", kindofgood="
					+ kindofgood + ", comments=" + comments  + ", user=" + user
					+ ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", rentperiod=" + rentperiod + ", Price="
					+ Price + ", rentingtype=" + rentingtype + "]";
		}

		

		public long getIdAcheteur() {
			return idAcheteur;
		}


		public void setIdAcheteur(long idAcheteur) {
			this.idAcheteur = idAcheteur;
		}


		public String getGarantie() {
			return garantie;
		}


		public void setGarantie(String garantie) {
			this.garantie = garantie;
		}


		public Date getDateAchat() {
			return dateAchat;
		}


		public void setDateAchat(Date dateAchat) {
			this.dateAchat = dateAchat;
		}


		public Etat getEtat() {
			return etat;
		}


		public void setEtat(Etat etat) {
			this.etat = etat;
		}


		public Ad(String description, String location, int area, KindOfGood kindofgood, User user, Date startDate,
				Date endDate, RentPeriod rentperiod, float price, RentingType rentingtype, int nbBaths, int nbRooms,
				int nbGarage, Boolean terrace, Boolean swimmingPool, Boolean garden, Boolean airConditioning,
				Boolean heater, Boolean sousSol, Boolean ascenseur, Boolean furnished) {
			super();
			Description = description;
			Location = location;
			Area = area;
			this.kindofgood = kindofgood;
			this.user = user;
			StartDate = startDate;
			EndDate = endDate;
			this.rentperiod = rentperiod;
			Price = price;
			this.rentingtype = rentingtype;
			this.nbBaths = nbBaths;
			this.nbRooms = nbRooms;
			this.nbGarage = nbGarage;
			Terrace = terrace;
			SwimmingPool = swimmingPool;
			Garden = garden;
			AirConditioning = airConditioning;
			this.heater = heater;
			SousSol = sousSol;
			this.ascenseur = ascenseur;
			Furnished = furnished;
		}


		public Ad(int idAd, String description, String image, String location, int area, Date adDate,
				KindOfGood kindofgood, User user, Date startDate, Date endDate, RentPeriod rentperiod, float price,
				RentingType rentingtype, int nbBaths, int nbRooms, int nbGarage) {
			super();
			IdAd = idAd;
			Description = description;
			this.image = image;
			Location = location;
			Area = area;
			AdDate = adDate;
			this.kindofgood = kindofgood;
			this.user = user;
			StartDate = startDate;
			EndDate = endDate;
			this.rentperiod = rentperiod;
			Price = price;
			this.rentingtype = rentingtype;
			this.nbBaths = nbBaths;
			this.nbRooms = nbRooms;
			this.nbGarage = nbGarage;
		}


		
	

		/*public void addComment(Comment comment){
			comment.setAds(this);
			this.comments.add(comment);
		}*/
	




	


	

	
	
		
		
		
}