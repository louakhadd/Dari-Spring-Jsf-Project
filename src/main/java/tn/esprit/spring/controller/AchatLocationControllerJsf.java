package tn.esprit.spring.controller;


import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.PrixParM2;
import tn.esprit.spring.entities.RentPeriod;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.WishListService;

@Scope(value = "session")
@Controller(value = "achatLocationControllerJsf")
@ELBeanName(value = "achatLocationControllerJsf")
@Join(path = "/", to = "/wishlist.jsf")
public class AchatLocationControllerJsf {
	@Autowired
	WishListService wishListService;
	@Autowired
	AchatLocationService achatService;
	@Autowired
	UserRestController userController;
	
	
	
	private int idw;
	static WishList wishlist;
	private int areamin; 
	private int areamax; 
	private int budgetmin; 
	private int budgetmax;
	private String location;
	private int nbBaths;
	private int nbRooms;
	private int nbGarage;
	private boolean terrace;
	private boolean swimmingPool;
	private boolean garden;
	private boolean furnished;
	private boolean airConditioning;
	private boolean heater;
	private boolean urgent;	
	private boolean sousSol;		
	private boolean ascenseur;
	
	private Date StartDate;
	private Date EndDate;
	private RentPeriod rentperiod;
	private RentingType typeAnnonce;
	private KindOfGood kindofgood;
//	private List<WishList> wishlists;	
	private List<WishList> wishlistsByUser;
	
	

	/////////////////////////////////////////////////////////////
				/*Prix par m2*/
	private PrixParM2 price;
	private int idp;
	private String ville;
	private float prixMaison;
	private float prixAppart;
	private List<PrixParM2> prices;
	private List<String> cities;
	
	private float minpMaison; 
	private float maxpMaison; 
	private float minpAppart; 
	private float maxpAppart;
	
	private float prixLoyerM;
	private float prixLoyerA;
	
	private List<PrixParM2> ResRecherche;
	/////////////////////////////////////////////////////////////
	
	
	
	
	/*Getters and setters*/

	public WishListService getWishListService() {
		return wishListService;
	}

	public void setWishListService(WishListService wishListService) {
		this.wishListService = wishListService;
	}

	

	public static WishList getWishlist() {
		return wishlist;
	}

	public static void setWishlist(WishList wishlist) {
		AchatLocationControllerJsf.wishlist = wishlist;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNbBaths() {
		return nbBaths;
	}

	public void setNbBaths(int nbBaths) {
		this.nbBaths = nbBaths;
	}

	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}
	
	public boolean isTerrace() {
		return terrace;
	}

	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	public int getNbGarage() {
		return nbGarage;
	}

	public void setNbGarage(int nbGarage) {
		this.nbGarage = nbGarage;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	public boolean isHeater() {
		return heater;
	}

	public void setHeater(boolean heater) {
		this.heater = heater;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}


	public boolean isSousSol() {
		return sousSol;
	}

	public void setSousSol(boolean sousSol) {
		this.sousSol = sousSol;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public RentingType getTypeAnnonce() {
		return typeAnnonce;
	}

	public void setTypeAnnonce(RentingType typeAnnonce) {
		this.typeAnnonce = typeAnnonce;
	}

	public KindOfGood getKindofgood() {
		return kindofgood;
	}

	public void setKindofgood(KindOfGood kindofgood) {
		this.kindofgood = kindofgood;
	}
	
	public RentingType[] getRentingTypes() {
		return RentingType.values();
	}
	public KindOfGood[] getKindOfGoods() {
		return KindOfGood.values();
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
	
	public RentPeriod[] getrentperiods() {
		return RentPeriod.values();
	}
	
	

	/////////////////////////////////////////////////////////////

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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
	
	public PrixParM2 getPrice() {
		return price;
	}

	public void setPrice(PrixParM2 price) {
		this.price = price;
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

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
	
	/////////////////////////////////////////////////////////////
	


	public List<String> getCities() {
		cities=achatService.allCities();
		return cities;
	}

	public List<PrixParM2> getPrices() { 
		prices=achatService.getAllPrices(); 
		return prices; 
	} 

	//////////////////////////////////////////////////////////////
	
	
/*
	public List<WishList> getWishlists() {
		wishlists = wishListService.retrieveAllWishLists();
		return wishlists;
	}
	*/
	
	public String RedirectToWishlist() {
		return "/client/wishlistAff.xhtml?faces-redirect=true";
	}
	
	public List<WishList> getWishlistsByUser() {
		System.out.println("Id client est:++"+ UserRestController.ClientConnecte.getId());
		wishlistsByUser = wishListService.getAllWhishListsByUser(UserRestController.ClientConnecte.getId());
		return wishlistsByUser;
	}

	
	/* End Getters and setters */
	
	public void addPrix(){
		System.out.println("TeeeeeeeeeeeeeeeeeeeestAdd");
		achatService.addOrUpdate(new PrixParM2(ville, prixMaison, prixAppart, minpMaison, maxpMaison, minpAppart, maxpAppart));
	}
	
	public void updatePrix(){
		System.out.println("TeeeeeeeeeeeeeeeeeeeestUpdate");
		achatService.addOrUpdate(new PrixParM2(idp,ville, prixMaison, prixAppart, minpMaison, maxpMaison, minpAppart, maxpAppart));
	}
	public void displayPrice(PrixParM2 prix){
		this.setVille(prix.getVille());
		this.setMinpMaison(prix.getMinpMaison());
		this.setPrixMaison(prix.getPrixMaison());
		this.setMaxpMaison(prix.getMaxpMaison());
		this.setMinpAppart(prix.getMinpAppart());
		this.setPrixAppart(prix.getPrixAppart());
		this.setMaxpAppart(prix.getMaxpAppart());		
	}
	


	public String addEmploye() {
		Client c=UserRestController.getClientConnecte();
		wishListService.addOrUpdateWishList(new WishList(areamin, areamax, budgetmin, budgetmax, location, nbBaths,nbRooms, nbGarage,terrace, 
				swimmingPool, garden, furnished,airConditioning, heater, urgent, sousSol, ascenseur,StartDate, EndDate, rentperiod,typeAnnonce, kindofgood,c));
		return "/client/wishlistAff.xhtml?faces-redirect=true";	
	}
	
	public String updateEmploye()
	{ 		
		System.out.println(wishlist);
		wishListService.addOrUpdateWishList(new WishList(wishlist.getIdw(), areamin, areamax, budgetmin, budgetmax, location, nbBaths,nbRooms, nbGarage,terrace, 
				swimmingPool, garden, furnished,airConditioning, heater, urgent, sousSol, ascenseur,StartDate, EndDate, rentperiod, typeAnnonce, kindofgood));
		return "wishlistAff";
	}
	
	public String edit(WishList prd) {
		wishlist=prd;
		System.out.println(wishlist);
		displayWishList(prd);
		//return "wishlistUpdate";
		return "/client/wishlistUpdate.xhtml?faces-redirect=true";
	}
	
	
	public void removeWishList(int id) {

		wishListService.deleteWishList(id);
	}
	
	public void displayWishList(WishList empl) {			

		this.setAreamin(empl.getAreamin());
		this.setAreamax(empl.getSurfacemax());
		this.setBudgetmin(empl.getBudgetmin());
		this.setBudgetmax(empl.getBudgetmax());
		this.setLocation(empl.getLocation());
		this.setNbBaths(empl.getNbBaths());
		this.setNbRooms(empl.getNbRooms());
		this.setNbGarage(empl.getNbGarage());
		this.setTerrace(empl.isTerrace());
		this.setSwimmingPool(empl.isSwimmingPool());
		this.setGarden(empl.isGarden());
		this.setFurnished(empl.isFurnished());
		this.setAirConditioning(empl.isAirConditioning());
		this.setHeater(empl.isHeater());
		this.setUrgent(empl.isUrgent());
		this.setSousSol(empl.isSousSol());
		this.setAscenseur(empl.isAscenseur());
		this.setTypeAnnonce(empl.getTypeAnnonce());
		this.setStartDate(empl.getStartDate());
		this.setRentperiod(empl.getRentperiod());
		this.setEndDate(empl.getEndDate());
		this.setKindofgood(empl.getKindofgood());

	}
	
	public String redirectAdd() {
		return "/client/wishlistAdd.xhtml?faces-redirect=true";
	}
	
	public String Search() {
		return "search";
	}
	
	public String AddRent() {
		return "/client/AddHouseRent.xhtml?faces-redirect=true";
	}
	
	public String AddSell() {
		return "/client/AddHouseSell.xhtml?faces-redirect=true";
	}

	public List<PrixParM2> getResRecherche() {
		return ResRecherche;
	}

	public void setResRecherche(List<PrixParM2> resRecherche) {
		ResRecherche = resRecherche;
	}
	

	
	
	
}
