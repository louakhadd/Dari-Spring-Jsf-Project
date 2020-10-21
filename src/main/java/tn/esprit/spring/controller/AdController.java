package tn.esprit.spring.controller;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.RentPeriod;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.FavoriteAdService;
import tn.esprit.spring.services.IAdService;
import tn.esprit.spring.services.RatingView;
import tn.esprit.spring.services.WishListService;


@Scope(value = "session")
@ELBeanName(value = "adController")
//@Join(path = "/", to = "/gererAd/basic.jsf")
@Controller(value = "adController")
public class AdController {


	public static final Logger l = LogManager.getLogger(IControllerAdImpl.class);
	@Autowired
	UserRestController urc;
	@Autowired
	IAdService iadService;
	@Autowired
	IAdService adService;
	@Autowired
	RatingView ratingview;
	@Autowired
	WishListService wlService;
	
	private int IdAd;
	private Ad ad;
	private Comment c;
	private List<Ad> ads;
	private List<Ad> kk;
	private List<Comment> com;
	private String Description;
	private String Location;
	private int Area;
	private int nbBaths;
	private String image;
	private KindOfGood kindofgood;
	private Date AdDate;
	private Integer adIdToBeUpdated;
	private int ViewsNumber;
	private Boolean Success;
	private int Score;
	private Date StartDate;
	private Date EndDate;
	private RentPeriod rentperiod;
	private RentingType rentingtype;
	private float Price;
	private UploadedFile file;
	private String DescriptionComment;
	private int NumberLikes;
	private User user;
	private Client client;
	private int IdComment;
	private String descCom;
	private int idPub;
	private Ad aadDialog;
	private int a;
	private int nbRooms;
	private int nbGarage;
	private Integer CommetIdToBeUpdated;
	private String destination = "C:\\Users\\Loua\\Documents\\workspace-sts-3.8.4.RELEASE\\dari-spring-boot\\src\\main\\webapp\\resources\\META-INF\\resources\\upload\\";
	private Ad Ads;
	private String updatedComment;
	private DonutChartModel donutModel;
	private DonutChartModel donutModel2;
	private int nbDisLikes;
	private Etat etat;
	private Boolean Furnished;
	private Boolean Terrace;
	private Boolean Garden;
	private Boolean SwimmingPool;
	private Boolean SousSol;
	private Boolean Garage;
	private Boolean AirConditioning;
	private Boolean Ascenseur;
	private Boolean Heater;
	private String newComment;
	private int IdRec;
	
	
////////////////////////////////////Loua////////////////////////////////////////////////////////////
	@Autowired
	AchatLocationService achatService;
	@Autowired
	FavoriteAdService favService;
	
	private float areamin;
	private float areamax;
	private float pricemin;
	private float pricemax;
	private List<Ad> lastSold;	
	private List<Ad> favoris;
	private List<Ad> historique;
	private List<Ad> vente;
	private List<Ad> Hrent;
	private List<Ad> Trent;
	private List<Ad> rent;
	private List<Ad> searchp;
	private List<Ad> search;
	
	
	
	public float getAreamin() {
		return areamin;
	}
	public void setAreamin(float areamin) {
		this.areamin = areamin;
	}
	public float getAreamax() {
		return areamax;
	}
	public void setAreamax(float areamax) {
		this.areamax = areamax;
	}
	public float getPricemin() {
		return pricemin;
	}
	public void setPricemin(float pricemin) {
		this.pricemin = pricemin;
	}
	public float getPricemax() {
		return pricemax;
	}
	public void setPricemax(float pricemax) {
		this.pricemax = pricemax;
	}
	public List<Ad> getLastSold() {
		lastSold = achatService.DernierBienVendu();
		return lastSold;
	}
	public List<Ad> getVente() {
		vente=null;
		vente = achatService.AnnonceVente();
		return vente;
	}
	public List<Ad> getHrent() {
		Hrent = achatService.AnnonceRentHoliday();
		return Hrent;
	}
	public List<Ad> getTrent() {
		Trent = achatService.AnnonceRentTemp();
		return Trent;
	}
	public List<Ad> getRent() {
		rent = achatService.AnnonceRent();
		return rent;
	}
	
	public String getSearch1() {
		search=null;
		if(rentingtype==null){
			search = achatService.RecherchePrimaireV(kindofgood.name(), Location, pricemin, pricemax);
		}
		else {
			search = achatService.RecherchePrimaireA(kindofgood.name(), Location, pricemin, pricemax);
		}
		return "/client/ResultSearch.xhtml?faces-redirect=true";
	}
	
	public String getSearchp1() {
		System.out.println("teeeeeeeeeeeest");System.out.println(rentingtype);System.out.println(rentingtype);
		
		if(rentingtype==null){
			searchp = achatService.FiltreMulticritèreV(kindofgood.name(), Location, areamin, areamax, pricemin, pricemax, nbBaths, nbRooms, nbGarage, 
			Terrace, SwimmingPool, Garden, AirConditioning, Heater, SousSol, Ascenseur);
		}
		else {
			searchp=achatService.FiltreMulticritèreA(kindofgood.name(), Location, areamin, areamax, pricemin, pricemax, nbBaths, nbRooms, nbGarage, 
					Terrace, SwimmingPool, Garden, AirConditioning, Heater, SousSol, Ascenseur, Furnished, rentingtype.name());
		}
		
		return "/client/ResultSearch2.xhtml?faces-redirect=true";
		
	}
	
	
	
	////////////////////////////////////Getters&Setters////////////////////////////////////////////////////////////
	
	

	public List<Ad> getSearch() {
		return search;
	}
	public void setSearch(List<Ad> search) {
		this.search = search;
	}
	public List<Ad> getSearchp() {
		return searchp;
	}
	public void setSearchp(List<Ad> searchp) {
		this.searchp = searchp;
	}
	
	
	
	public int getA() {
		return a;
	}


	public String getNewComment() {
		return newComment;
	}





	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}


	public Etat getEtat() {
		return etat;
	}



	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	public UserRestController getUrc() {
		return urc;
	}



	public void setUrc(UserRestController urc) {
		this.urc = urc;
	}

	
	public Boolean getFurnished() {
		return Furnished;
	}



	public void setFurnished(Boolean furnished) {
		Furnished = furnished;
	}



	public Boolean getTerrace() {
		return Terrace;
	}



	public void setTerrace(Boolean terrace) {
		Terrace = terrace;
	}



	public Boolean getGarden() {
		return Garden;
	}



	public void setGarden(Boolean garden) {
		Garden = garden;
	}



	public Boolean getSwimmingPool() {
		return SwimmingPool;
	}



	public void setSwimmingPool(Boolean swimmingPool) {
		SwimmingPool = swimmingPool;
	}



	public Boolean getSousSol() {
		return SousSol;
	}



	public void setSousSol(Boolean sousSol) {
		SousSol = sousSol;
	}



	public Boolean getGarage() {
		return Garage;
	}



	public void setGarage(Boolean garage) {
		Garage = garage;
	}



	public Boolean getAirConditioning() {
		return AirConditioning;
	}



	public void setAirConditioning(Boolean airConditioning) {
		AirConditioning = airConditioning;
	}



	public Boolean getAscenseur() {
		return Ascenseur;
	}



	public void setAscenseur(Boolean ascenseur) {
		Ascenseur = ascenseur;
	}



	public Boolean getHeater() {
		return Heater;
	}



	public void setHeater(Boolean heater) {
		Heater = heater;
	}



	public static Logger getL() {
		return l;
	}



	public DonutChartModel getDonutModel2() {
		return donutModel2;
	}



	public void setDonutModel2(DonutChartModel donutModel2) {
		this.donutModel2 = donutModel2;
	}



	public DonutChartModel getDonutModel() {
		return donutModel;
	}



	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}



	public int getNbDisLikes() {
		return nbDisLikes;
	}



	public void setNbDisLikes(int nbDisLikes) {
		this.nbDisLikes = nbDisLikes;
	}



	public void setAds(Ad ads) {
		Ads = ads;
	}



	public RatingView getRatingview() {
		return ratingview;
	}



	public void setRatingview(RatingView ratingview) {
		this.ratingview = ratingview;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public Integer getCommetIdToBeUpdated() {
		return CommetIdToBeUpdated;
	}

	public void setCommetIdToBeUpdated(Integer commetIdToBeUpdated) {
		this.CommetIdToBeUpdated = commetIdToBeUpdated;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public int getNbRooms() {
		return nbRooms;
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

	public void setA(int a) {
		this.a = a;
	}

	public Ad getAadDialog() {
		return aadDialog;
	}

	public void setAadDialog(Ad aadDialog) {
		this.aadDialog = aadDialog;
	}

	public int getIdComment() {
		return IdComment;
	}

	public void setIdComment(int idComment) {
		IdComment = idComment;
	}

	public IAdService getIadService() {
		return iadService;
	}

	public void setIadService(IAdService iadService) {
		this.iadService = iadService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}



	public int getIdPub() {
		return idPub;
	}

	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getDescCom() {
		return descCom;
	}

	public void setDescCom(String descCom) {
		this.descCom = descCom;
	}


	private Ad selectedAd;


	public Ad getSelectedAd() {
		return selectedAd;
	}

	public void setSelectedAd(Ad selectedAd) {
		this.selectedAd = selectedAd;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Comment getC() {
		return c;
	}

	public void setC(Comment c) {
		this.c = c;
	}

	public List<Comment> getCom() {
		return com;
	}

	public void setCom(List<Comment> com) {
		this.com = com;
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
	  
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	 


	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
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
	public int getViewsNumber() {
		return ViewsNumber;
	}

	public void setViewsNumber(int viewsNumber) {
		ViewsNumber = viewsNumber;
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

	public Integer getAdIdToBeUpdated() {
		return adIdToBeUpdated;
	}

	public void setAdIdToBeUpdated(Integer adIdToBeUpdated) {
		this.adIdToBeUpdated = adIdToBeUpdated;
	}

	public int getIdAd() {
		return IdAd;
	}

	public void setIdAd(int idAd) {
		IdAd = idAd;
	}


	public Date getAdDate() {
		return AdDate;
	}

	public void setAdDate(Date adDate) {
		AdDate = adDate;
	}

	public KindOfGood[] getKindofgoods() {
		return KindOfGood.values();
	}

	public KindOfGood getKindofgood() {
		return kindofgood;
	}

	public IAdService getAdService() {
		return adService;
	}

	public void setAdService(IAdService adService) {
		this.adService = adService;
	}

	public void setKindofgood(KindOfGood kindofgood) {
		this.kindofgood = kindofgood;
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

	public int getArea() {
		return Area;
	}

	public void setArea(int area) {
		Area = area;
	}

	public Ad getAd() {
		return ad;
	}


	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public List<Ad> getAds() {
		ads = adService.retrieveAllAds();
		return ads;
	}

	public RentingType[] getrentingtypes() {
		return RentingType.values();
	}

	public RentingType getRentingtype() {
		return rentingtype;
	}

	public void setRentingtype(RentingType rentingtype) {
		this.rentingtype = rentingtype;
	}


	public int getNbBaths() {
		return nbBaths;
	}

	public void setNbBaths(int nbBaths) {
		this.nbBaths = nbBaths;
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////


 public String getUpdatedComment() {
		return updatedComment;
	}



	public void setUpdatedComment(String updatedComment) {
		this.updatedComment = updatedComment;
	}



public Ad addAd(Ad ad) { 
	Ad a = iadService.addAd(ad); 
	return a; 
	}

	
	public String addad() {
		System.out.println("tttttttttttttttttttttt");
		
		Client c=UserRestController.ClientConnecte;
		adService.addAd(new Ad(Description, Location, Area, kindofgood, c, StartDate, EndDate, rentperiod, Price, rentingtype, nbBaths, nbRooms, nbGarage, Terrace, 
				SwimmingPool, Garden, AirConditioning, Heater, SousSol, Ascenseur, Furnished));
		
/*		try {
			upload();
			TransferFile(file.getFileName(), file.getInputStream());
			tmp.setImage(file.getFileName());
			tmp.setEtat(Etat.Disponible);

			l.info("uploaded");
			
		} catch (Exception e) {
			l.info(e.toString());
		}
		
		User currentuser = urc.getClientConnecte();
		Date currentdate = new Date();
		Ad adnotif;
		
		adnotif = adService.addAd(tmp);	*/
	
		

	return "/client/Accueil.xhtml?faces-redirect=true";

	}


	public String SeeAllAds(){
		
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}
	
	public List<Ad> getKk() {
	

		kk=adService.filter();

		return kk;
	}

	public void setKk(List<Ad> kk) {
		this.kk = kk;
	}

	public void deleteAd(int IdAd) {
		iadService.deleteAd(IdAd);
	}

	public String removeAd(int IdAd) {
		adService.deleteAd(IdAd);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}

	public String displayAd(Ad ad) {
		this.setImage(ad.getImage());
		this.setKindofgood(ad.getKindofgood());
		this.setLocation(ad.getLocation());
		this.setArea(ad.getArea());
		this.setDescription(ad.getDescription());
		this.setUser(ad.getUser());
		this.setPrice(ad.getPrice());
		this.setNbRooms(ad.getNbRooms());
		this.setNbGarage(ad.getNbGarage());
		this.setAdIdToBeUpdated(ad.getIdAd());
		this.setAdDate(ad.getAdDate());
		this.setStartDate(ad.getStartDate());
		this.setEndDate(ad.getEndDate());
		this.setRentperiod(ad.getRentperiod());
		this.setRentingtype(ad.getRentingtype());
		this.setNbBaths(ad.getNbBaths());
		
		return "/client/AdModify.xhtml?faces-redirect=true";
	
	}
	
	
	public String openDetail(Ad aad){
	     ad = aad;
			return "/client/DetailAnnonce.xhtml?faces-redirect=true";
	    }
	public String go() {
		return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";
	}

	public String ClearAd() {
		//String navigateTo = "null";
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setDescription(null);
		this.setAdIdToBeUpdated(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		//navigateTo = "/webapp/gererAd/ModifyAd.xhtml?faces-redirect=true";
		return "/gererAd/AddHouseSell.xhtml?faces-redirect=true";

	}

	
	
	public String Clear() {
		//String navigateTo = "null";
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setDescription(null);
		this.setAdIdToBeUpdated(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		//navigateTo = "/webapp/gererAd/ModifyAd.xhtml?faces-redirect=true";
		return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";

	}
	
	public String ClearAdRent() {
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setStartDate(null);
		this.setEndDate(null);
		this.setDescription(null);
		this.setRentperiod(null);
		this.setRentingtype(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		this.setAdIdToBeUpdated(null);
		return "/gererAd/AddHouseRent.xhtml?faces-redirect=true";

	} 
	
		
	
	public String updateAd() {
		
		User currentuser = urc.getClientConnecte();
		Date currentdate = new Date();
		//Ad adnotif;
		
		adService.addOrUpdateAd(new Ad(adIdToBeUpdated,Description,image, Location, Area,currentdate,kindofgood,currentuser,StartDate,
				EndDate,rentperiod,Price,rentingtype,nbBaths,nbRooms,nbGarage));
		
		
		return "/client/Accueil.xhtml?faces-redirect=true";

	}

	public Ad modifyAd(@RequestBody Ad ad) {
		return iadService.updateAd(ad);
	}

	public Ad getAdById(int adId) {
		return adService.getAdById(adId);
	}
	public void addMessage(String summary) {  //addMessage("Data saved");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);}

	public String getAdById1(int idAd) {

		l.info("aaaaaaaaaa"+idAd);
		adService.getAdById(idAd);
		//getAllCommentsByAd
		setIdPub(idAd);
		setCom(adService.DescriptionComments(idAd)); 
		return "/gererAd/DescriptionComment.xhtml?faces-redirect=true";
	}

/*	loua	
	public String addComment() {

		
		Client c=urc.getClientConnecte();
		System.out.println("cmnt " + newComment);
		Comment cmnt = new Comment();
		cmnt.setDescriptionComment(newComment);
		cmnt.setIsBlocked(false);
		cmnt.setAds(ad);
		cmnt.setClient(c);
		adService.addCommentaire(cmnt);
		return "/gererAd/basic.xhtml?faces-redirect=true";

	}

	public String addComment1(int idAd) {
		Client c=urc.getClientConnecte();
		
		adService.addComment(new Comment(descCom),c.getId(), idPub,false);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	} */


	public String removeComment(int idComment) {
		//String navigateTo = "null";
		l.info("hhhhhhhhhhh"+ idComment);
		adService.deleteComment(idComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";


	}
	/*public String deleteComment(int idComment) {
		adService.deleteComment(idComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";}
		
	*/
	public List<Comment> listCommentaire(Ad ad) {
		return ad.getComments();
	}
	
	public Comment UpdateComment(Comment comment) {
		return adService.UpdateComment(comment);
		
	}
	
	
	public String ModifyComment() {
		System.out.println("cccmmt "+updatedComment);
	adService.addOrUpdateComment(new Comment(CommetIdToBeUpdated,updatedComment,client,Ads));
		l.info("modifyyyyyy    "+ CommetIdToBeUpdated);
	return "/gererAd/basic.xhtml?faces-redirect=true";
	}


	public void AssignCommentToanAd(int CommentId, int AdId) {
		iadService.AssignCommentToanAd(CommentId, AdId);
	}

	public List<String> getAllCommentsByAd(int AdId) {
		return adService.getAllCommentsByAd(AdId);
	}
	public void displayComment(Comment com) {
		
		this.setUpdatedComment(com.getDescriptionComment());
		this.setNumberLikes(com.getNumberLikes());
		this.setClient(com.getClient());
		this.setAds(com.getAds());
		this.setCommetIdToBeUpdated(com.getIdComment());
	}


	public String displayAdComment(Comment c) {

		this.setDescriptionComment(c.getDescriptionComment());
		this.setCommetIdToBeUpdated(c.getIdComment());
		return "/gererAd/showComments.xhtml?faces-redirect=true";

	}

	public int countComments() {

		return iadService.countComments();
	}

	public int nbrLike() {
		return iadService.nbrLike();
	}

	public List<Ad> getAdWithBestLikesOnCommentsJPQL() {
		return iadService.getAdWithBestLikesOnCommentsJPQL();
	}

	public int maxnblike() {
		return iadService.maxnblike();
	}

	public boolean succes() {
		return iadService.succes();
	}

	public double AVG_nbcomment() {
		return iadService.AVG_nbcomment();
	}

	public boolean BlockCommentsWithInsultingWords() {
		return iadService.BlockCommentsWithInsultingWords();
	}

	public void ScoreIncrement() {
		iadService.ScoreIncrement();
	}

	public int AdsForToday() {
		return iadService.AdsForToday();
	}

	public double AVG_Ads_Year() {
		return iadService.AVG_Ads_Year();
	}

	public double countAds() {
		return iadService.countAds();
	}

	public List<String> getAllCommentsBlockedJPQL() {
		return iadService.getAllCommentsBlockedJPQL();

	}

	public List<String> getAdsFromTheSameUserJPQL() {
		return iadService.getAdsFromTheSameUserJPQL();

	}

	public int countCommentsJPQL(int IdAd) {
		return iadService.countCommentsJPQL(IdAd);
	}
	public int getNumberView(int idad) {
		return iadService.getNumberView(idad);
	}
	public int getNumberViewId(int idad) {
		return adService.getNumberView(idad);
	}

	public boolean increment(int idad) {
		return iadService.increment(idad);

	}
	public boolean incrementad(int idAd) {
		a=ratingview.getRating8(idAd);
		ad = adService.getAdById(idAd);
		//setAadDialog(adService.getAdById(idAd)); 
		//adService.getAdById(idAd);
		l.info("mmmmmmm" + idAd);
		return adService.increment(idAd);

	}

	public Integer getRating8(int idad) {
		return ratingview.getRating8(idad);
	}



	public String BlockCommentsWithInsultingWords2(int idComment) {
		
		//c = adService.getCommentById(IdComment);
		l.info("Id Of Comment isssssss   " + idComment);
		adService.getCommentById(idComment);
		 iadService.BlockCommentsWithInsultingWords2(idComment);
		 return "/Login/dashbordad.xhtml?faces-redirect=true";
	
	}

	public void BlockUserByBadComments() {
		adService.BlockUserByBadComments();
	}
	public String incrementdislike(int idad) {
		adService.incrementdislike(idad);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}
	public String incrementlike(int idad) {
		 adService.incrementlike(idad);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}

	/*private List<Predicate<Ad>> configFilter(Filter<Ad> filter) {
    List<Predicate<Ad>> predicates = new ArrayList<>();
    if (filter.hasParam("id")) {
        Predicate<Ad> idPredicate = (Ad c) -> c.getIdAd().equals(filter.getParam("id"));
        predicates.add(idPredicate);
    }

    if (filter.hasParam("minPrice") && filter.hasParam("maxPrice")) {
        Predicate<Ad> minMaxPricePredicate = (Ad c) -> c.getPrice()
                >= Double.valueOf((String) filter.getParam("minPrice")) && c.getPrice()
                <= Double.valueOf((String) filter.getParam("maxPrice"));
        predicates.add(minMaxPricePredicate);
    } else if (filter.hasParam("minPrice")) {
        Predicate<Ad> minPricePredicate = (Ad c) -> c.getPrice()
                >= Double.valueOf((String) filter.getParam("minPrice"));
        predicates.add(minPricePredicate);
    } else if (filter.hasParam("maxPrice")) {
        Predicate<Ad> maxPricePredicate = (Ad c) -> c.getPrice()
                <= Double.valueOf((String) filter.getParam("maxPrice"));
        predicates.add(maxPricePredicate);
    }

    if (has(filter.getEntity())) {
    	Ad filterEntity = filter.getEntity();
        if (has(filterEntity.getModel())) {
            Predicate<Ad> modelPredicate = (Ad c) -> c.getModel().toLowerCase().contains(filterEntity.getModel().toLowerCase());
            predicates.add(modelPredicate);
        }

        if (has(filterEntity.getPrice())) {
            Predicate<Ad> pricePredicate = (Ad c) -> c.getPrice().equals(filterEntity.getPrice());
            predicates.add(pricePredicate);
        }

        if (has(filterEntity.getName())) {
            Predicate<Ad> namePredicate = (Ad c) -> c.getName().toLowerCase().contains(filterEntity.getName().toLowerCase());
            predicates.add(namePredicate);
        }
    }
    return predicates;
}*/
	public List<Ad> filter(){

		return iadService.filter();
	}
	public List<Comment> DescriptionComments(int idc) {
		return iadService.DescriptionComments(idc);
	}



	public void upload() {

		if (file != null) {
			FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else
			System.out.println("file is null");
	}

	public void handleFileUpload(FileUploadEvent event) {
		l.info("ddddddddddddddd " + event.getFile().getFileName());
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void TransferFile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int reader = 0;
			byte[] bytes = new byte[(int) file.getSize()];
			while ((reader = in.read(bytes)) != -1) {
				out.write(bytes, 0, reader);
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String donutGraph(Model model) {
		
		donutModel = new DonutChartModel();
        ChartData data = new ChartData();
         
        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(adService.nbrLikeAd());
		values.add(adService.nbrDislikeAd());
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(45, 71, 133)");
        bgColors.add("rgb(230, 16, 190)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Numbre Of likes");
		labels.add("Numbre Of dislikes");
        data.setLabels(labels);
         
        donutModel.setData(data);
		return "/gererAd/donutGraph.xhtml?faces-redirect=true";
	}
	
	
	/*
	public String openDetail1(Ad a) {
		ad = a;
		setBonus(a.getBonus());
		return "/gererAd/chaquead.xhtml?faces-redirect=true";
	}

	public String openDetaildashbord(Ad a) {
		ad = a;
		setBonus(a.getBonus());
		return "/Login/chaqueaddashbord.xhtml?faces-redirect=true";
	}
	/*
	public String openDetailnotification(Ad a) {
		ad = a;
		setBonus(a.getBonus());
		return "/Login/chaqueaddashbord.xhtml?faces-redirect=true";
	}
	public String reclamerComment(Comment comm) {
		
		Reclamation rec = new Reclamation();
		l.info("aaaaaaaaaaaaaaaah" + comm.getDescriptionComment());
		c = comm;
		rec.setCommentaire(comm);
		ReclamationService.addReclamation(rec);

		return "/gererAd/basic.xhtml?faces-redirect=true";

	}
	*/
	

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	/////////////////////// Fonction loua//////////////////////////////////
	
	public String RedirectToHistorique() {
		return "/client/Historique.xhtml?faces-redirect=true";
	}
	
	public List<Ad> getHistorique() {
		historique=achatService.BienVenduParClient(UserRestController.ClientConnecte.getId());
		return historique;
	}
	public String RedirectToFavorite() {
		return "/client/Favorite.xhtml?faces-redirect=true";
	}
	
	public List<Ad> getFavoris() {
		favoris=favService.getAllFavoritesByClient(UserRestController.ClientConnecte.getId());
		return favoris;
	}
	
	public void sold(int id){
		System.out.println("Teeeeeeeeeeeeeeeeeeeeeeeest");
		achatService.Archiver(id);
		//return "/Favorite.xhtml?faces-redirect=true";
	}
	
	public void favoris(int id){
		System.out.println("Teeeeeeeeeeeeeeeeeeeeeeeest");
		favService.favoriserAnnonce(id, UserRestController.ClientConnecte.getId());
	}
}
