package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_WISHLIST")
public class WishList {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idw;

	private int areamin;
	private int areamax;
	private int budgetmin;
	private int budgetmax;
	private String location;
	private int nbBaths;
	private int nbRooms;
	private int nbGarage;
	private boolean Terrace;
	private boolean SwimmingPool;
	private boolean Garden;
	private boolean Furnished;
	private boolean AirConditioning;
	private boolean heater;
	private boolean urgent;
	private boolean SousSol;
	private boolean ascenseur;
	
	private Date StartDate;
	private Date EndDate;
	@Enumerated(EnumType.STRING)
	private RentPeriod rentperiod;
	
	@Enumerated(EnumType.STRING)
	private RentingType typeAnnonce;

	@Enumerated(EnumType.STRING)
	private KindOfGood kindofgood;

	@ManyToOne
	User user;

	/////////////////////////// constructeur //////////////////////////

	public WishList() {
		super();
	}

	public WishList(int idw, int surfacemin, int surfacemax, int budgetmin, int budgetmax, String location, int nbPiece, int nbGarage,
			int nbRooms, boolean terrace, boolean swimmingPool,
			boolean garden, boolean furnished, boolean airConditioning, boolean heater, boolean urgent,
			boolean sousSol, boolean ascenseur, RentingType typeAnnonce, KindOfGood kindofgood, User user) {
		super();
		this.idw = idw;
		this.areamin = surfacemin;
		this.areamax = surfacemax;
		this.budgetmin = budgetmin;
		this.budgetmax = budgetmax;
		this.location = location;
		this.nbBaths = nbPiece;
		this.nbRooms = nbRooms;
		this.nbGarage= nbGarage;
		Terrace = terrace;
		SwimmingPool = swimmingPool;
		Garden = garden;
		Furnished = furnished;
		AirConditioning = airConditioning;
		this.heater = heater;
		this.urgent = urgent;
		SousSol = sousSol;
		this.ascenseur = ascenseur;
		this.typeAnnonce = typeAnnonce;
		this.kindofgood = kindofgood;
		this.user = user;
	}



	////////////////// Getters and Setters ////////////////////////

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdw() {
		return idw;
	}

	public void setIdw(int idw) {
		this.idw = idw;
	}

	public int getAreamin() {
		return areamin;
	}

	public void setAreamin(int areamin) {
		this.areamin = areamin;
	}

	public int getAreamax() {
		return areamax;
	}

	public void setAreamax(int areamax) {
		this.areamax = areamax;
	}

	public int getSurfacemax() {
		return areamax;
	}

	public void setSurfacemax(int surfacemax) {
		this.areamax = surfacemax;
	}

	public int getBudgetmin() {
		return budgetmin;
	}

	public void setBudgetmin(int budgetmin) {
		this.budgetmin = budgetmin;
	}

	public int getBudgetmax() {
		return budgetmax;
	}

	public void setBudgetmax(int budgetmax) {
		this.budgetmax = budgetmax;
	}

	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
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

	public int getNbGarage() {
		return nbGarage;
	}

	public void setNbGarage(int nbGarage) {
		this.nbGarage = nbGarage;
	}

	public boolean isGarden() {
		return Garden;
	}

	public void setGarden(boolean garden) {
		Garden = garden;
	}

	public boolean isFurnished() {
		return Furnished;
	}

	public void setFurnished(boolean furnished) {
		Furnished = furnished;
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

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public void setSousSol(boolean sousSol) {
		SousSol = sousSol;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public KindOfGood getKindofgood() {
		return kindofgood;
	}

	public void setKindofgood(KindOfGood kindofgood) {
		this.kindofgood = kindofgood;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


/*	@Override
	public String toString() {
		return "WishList [IdW=" + idw + ", surfacemin=" + surfacemin + ", surfacemax=" + surfacemax + ", budgetmin="
				+ budgetmin + ", budgetmax=" + budgetmax + ", location=" + location + ", nbRooms=" + nbRooms
				+ ", buildable=" + buildable + ", serviced=" + serviced + ", Terrace=" + Terrace + ", SwimmingPool="
				+ SwimmingPool + ", Garage=" + nbGarage + ", Garden=" + Garden + ", Furnished=" + Furnished
				+ ", AirConditioning=" + AirConditioning + ", heater=" + heater + ", kindofgood=" + kindofgood
				+ ", client=" + client + "]";
	}*/

	@Override
	public String toString() {
		return "WishList [idw=" + idw + ", surfacemin=" + areamin + ", surfacemax=" + areamax + ", budgetmin="
				+ budgetmin + ", budgetmax=" + budgetmax + ", location=" + location + ", nbBaths=" + nbBaths
				+ ", nbRooms=" + nbRooms + ", nbGarage=" + nbGarage + ", Terrace=" + Terrace + ", SwimmingPool="
				+ SwimmingPool + ", Garden=" + Garden + ", Furnished=" + Furnished + ", AirConditioning="
				+ AirConditioning + ", heater=" + heater + ", urgent=" + urgent + ", SousSol=" + SousSol
				+ ", ascenseur=" + ascenseur + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", rentperiod="
				+ rentperiod + ", typeAnnonce=" + typeAnnonce + ", kindofgood=" + kindofgood + "]";
	}
	

	public boolean isUrgent() {
		return urgent;
	}

	public boolean isSousSol() {
		return SousSol;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public int getNbBaths() {
		return nbBaths;
	}

	public void setNbBaths(int nbBaths) {
		this.nbBaths = nbBaths;
	}

	public RentingType getTypeAnnonce() {
		return typeAnnonce;
	}

	public void setTypeAnnonce(RentingType typeAnnonce) {
		this.typeAnnonce = typeAnnonce;
	}
	
	

	/////////////////////// jsf////////////////


	public WishList(int idw, int surfacemin, int surfacemax, int budgetmin, int budgetmax, String location, int nbBaths,
			int nbRooms, int nbGarage, boolean terrace, boolean swimmingPool, boolean garden, boolean furnished,
			boolean airConditioning, boolean heater, boolean urgent, boolean sousSol, boolean ascenseur,
			Date startDate, Date endDate, RentPeriod rentperiod, RentingType typeAnnonce, KindOfGood kindofgood) {
		super();
		this.idw = idw;
		this.areamin = surfacemin;
		this.areamax = surfacemax;
		this.budgetmin = budgetmin;
		this.budgetmax = budgetmax;
		this.location = location;
		this.nbBaths = nbBaths;
		this.nbRooms = nbRooms;
		this.nbGarage = nbGarage;
		Terrace = terrace;
		SwimmingPool = swimmingPool;
		Garden = garden;
		Furnished = furnished;
		AirConditioning = airConditioning;
		this.heater = heater;
		this.urgent = urgent;
		SousSol = sousSol;
		this.ascenseur = ascenseur;
		StartDate = startDate;
		EndDate = endDate;
		this.rentperiod = rentperiod;
		this.typeAnnonce = typeAnnonce;
		this.kindofgood = kindofgood;
	}

	public WishList(int surfacemin, int surfacemax, int budgetmin, int budgetmax, String location, int nbBaths,
			int nbRooms, int nbGarage, boolean terrace, boolean swimmingPool, boolean garden, boolean furnished,
			boolean airConditioning, boolean heater, boolean urgent, boolean sousSol, boolean ascenseur,
			Date startDate, Date endDate, RentPeriod rentperiod, RentingType typeAnnonce, KindOfGood kindofgood) {
		super();
		this.areamin = surfacemin;
		this.areamax = surfacemax;
		this.budgetmin = budgetmin;
		this.budgetmax = budgetmax;
		this.location = location;
		this.nbBaths = nbBaths;
		this.nbRooms = nbRooms;
		this.nbGarage = nbGarage;
		Terrace = terrace;
		SwimmingPool = swimmingPool;
		Garden = garden;
		Furnished = furnished;
		AirConditioning = airConditioning;
		this.heater = heater;
		this.urgent = urgent;
		SousSol = sousSol;
		this.ascenseur = ascenseur;
		StartDate = startDate;
		EndDate = endDate;
		this.rentperiod = rentperiod;
		this.typeAnnonce = typeAnnonce;
		this.kindofgood = kindofgood;
	}

	public WishList(int areamin, int areamax, int budgetmin, int budgetmax, String location, int nbBaths,
			int nbRooms, int nbGarage, boolean terrace, boolean swimmingPool, boolean garden, boolean furnished,
			boolean airConditioning, boolean heater, boolean urgent, boolean sousSol, boolean ascenseur, Date startDate,
			Date endDate, RentPeriod rentperiod, RentingType typeAnnonce, KindOfGood kindofgood, User user) {
		super();
		this.areamin = areamin;
		this.areamax = areamax;
		this.budgetmin = budgetmin;
		this.budgetmax = budgetmax;
		this.location = location;
		this.nbBaths = nbBaths;
		this.nbRooms = nbRooms;
		this.nbGarage = nbGarage;
		Terrace = terrace;
		SwimmingPool = swimmingPool;
		Garden = garden;
		Furnished = furnished;
		AirConditioning = airConditioning;
		this.heater = heater;
		this.urgent = urgent;
		SousSol = sousSol;
		this.ascenseur = ascenseur;
		StartDate = startDate;
		EndDate = endDate;
		this.rentperiod = rentperiod;
		this.typeAnnonce = typeAnnonce;
		this.kindofgood = kindofgood;
		this.user = user;
	}

	
	
	

}
