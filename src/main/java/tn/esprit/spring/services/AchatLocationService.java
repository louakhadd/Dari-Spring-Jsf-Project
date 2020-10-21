package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.EOrientation;
import tn.esprit.spring.entities.EStanding;
import tn.esprit.spring.entities.ETypeCave;
import tn.esprit.spring.entities.ETypePiscine;
import tn.esprit.spring.entities.EVue;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.PrixParM2;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.WishList;


public interface AchatLocationService {
	List<Ad> AnnonceVente();
	List<Ad> AnnonceRent();
	List<Ad> AnnonceRentTemp();
	List<Ad> AnnonceRentHoliday();
	
	void Archiver(int idAd);
	List<Ad> DernierBienVendu();
	List<Ad> BienVenduParClient(long idClient);
	

	//// Filtre multicritères 

	List<Ad> RecherchePrimaireV(String KindOfGood, String location, float budgetMin, float budgetMax);
	List<Ad> RecherchePrimaireA(String KindOfGood, String location, float budgetMin, float budgetMax);
	List<Ad> FiltreMulticritèreV(String KindOfGood, String location,float surfaceMin, float surfaceMax, float budgetMin, float budgetMax,int nbBaths, int nbChambre, int nbGarage,
			Boolean Terrace, Boolean SwimmingPool, Boolean Garden, Boolean AirConditioning,	Boolean heater, Boolean sousSol,Boolean ascenseur);
	
	List<Ad> FiltreMulticritèreA(String KindOfGood, String location,float surfaceMin, float surfaceMax, float budgetMin, float budgetMax,int nbBaths, int nbChambre, int nbGarage,
			Boolean Terrace, Boolean SwimmingPool,Boolean Garden, Boolean AirConditioning,	Boolean heater, Boolean sousSol,Boolean ascenseur, Boolean furnished,String RentingType);
	
	//List<PrixParM2> PrixParM2(); 
	float EstimationMaison(String Ville,float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT, Boolean Garden,Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP,
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave, float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux, EStanding standing , EVue vue, EOrientation orientation);
	
	
	float EstimationMinMaison(String Ville,float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT, Boolean Garden,Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP,
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave, float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux, EStanding standing , EVue vue, EOrientation orientation);

	float EstimationMaxMaison(String Ville,float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT, Boolean Garden,Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP,
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave, float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux, EStanding standing , EVue vue, EOrientation orientation);

	
	float EstimationAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien,  int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,
			Boolean heater,	Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation);
	
	float EstimationMinAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien,  int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,
			Boolean heater,	Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation);
	
	float EstimationMaxAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien,  int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,
			Boolean heater,	Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation);
	
	//////////EstimerLoyer/////////////////
	float EstimationLoyerMaison(String Ville,float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,Boolean Terrace, Boolean Garden,Boolean Garage, Boolean SwimmingPool, Boolean AirConditioning,Boolean heater,
			Boolean cave, Boolean Alarme, Boolean CamSurveillance,Boolean calme, Boolean dependance, EStanding standing , EVue vue, EOrientation orientation);
	
	float EstimationLoyerAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien, int nbPiece,int NbChambre, 
			int NbBathrooms,Boolean balcon,Boolean Terrace,Boolean Garden, Boolean Parking, Boolean AirConditioning,Boolean heater,	Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance,EStanding standing, EVue vue, EOrientation orientation);
	
	
	/////////////////
	void RemplissageTablePrix();
	List<String> allCities();
	
	
	////////////////// Taut d'achat
	List<Number> Fonction1();
	List<Number> Fonction2();
	List<Number> Fonction3();
	List<Number> Fonction4();
	List<Number> Fonction5();
	List<Number> Fonction6();
	List<Number> Fonction7();
	

	void goodEstimation();
	void highEstimation();
	void lowEstimation();
	
	
	/////////////////////// JSF //////////////////////////////////
	List<PrixParM2> getAllPrices();
	
	PrixParM2 addPrix(PrixParM2 p);
	PrixParM2 updatePrix(PrixParM2 p);
	int addOrUpdate(PrixParM2 p);
}
