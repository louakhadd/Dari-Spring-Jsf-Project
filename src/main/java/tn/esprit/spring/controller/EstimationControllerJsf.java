package tn.esprit.spring.controller;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.EOrientation;
import tn.esprit.spring.entities.EStanding;
import tn.esprit.spring.entities.ETypeCave;
import tn.esprit.spring.entities.ETypePiscine;
import tn.esprit.spring.entities.EVue;
import tn.esprit.spring.services.AchatLocationService;


@Scope(value = "session")
@Controller(value = "estimationControllerJsf")
@ELBeanName(value = "estimationControllerJsf")
public class EstimationControllerJsf {
	
	@Autowired
	AchatLocationService achatLocationService;
	
	private float surfaceAppartement;
	private int nbEtageTotal;
	private int nbEtage; 
	private boolean ascenseur;
	private boolean gardien;
	
	private String ville;
	private  float surfaceTotal; 
	private  float surfaceConstruit;
	private int nbNiveaux;
	private int nbPiece;
	private int nbChambre; 
	private int nbBathrooms;
	private boolean balcon;
	private int surfaceB;
	private boolean terrace;
	private float surfaceT;
	private boolean garden;
	private boolean garage; 
	private boolean swimmingPool;
	private ETypePiscine typeP;
	private float surfaceP;
	private boolean airConditioning;
	private boolean heater;	
	private boolean cave;
	private float surfaceC; 
	private ETypeCave typeCave; 
	private boolean alarme;
	private boolean camSurveillance;
	private boolean calme;
	private boolean dependance;
	private boolean traveaux;
	private EVue vue;
	private EOrientation orientation;
	private EStanding standing;
	
	public static float total;
	public static float total2;
	public static float total3;
	public static float total4;
	public static float total5;
	public static float total6;
	public static float total7;
	public static float total8;
		
	public AchatLocationService getAchatLocationService() {
		return achatLocationService;
	}
	public void setAchatLocationService(AchatLocationService achatLocationService) {
		this.achatLocationService = achatLocationService;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public float getSurfaceTotal() {
		return surfaceTotal;
	}
	public void setSurfaceTotal(float surfaceTotal) {
		this.surfaceTotal = surfaceTotal;
	}
	public float getSurfaceConstruit() {
		return surfaceConstruit;
	}
	public void setSurfaceConstruit(float surfaceConstruit) {
		this.surfaceConstruit = surfaceConstruit;
	}
	public int getNbNiveaux() {
		return nbNiveaux;
	}
	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}
	public int getNbPiece() {
		return nbPiece;
	}
	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	public int getNbChambre() {
		return nbChambre;
	}
	public void setNbChambre(int nbChambre) {
		this.nbChambre = nbChambre;
	}
	public int getNbBathrooms() {
		return nbBathrooms;
	}
	public void setNbBathrooms(int nbBathrooms) {
		this.nbBathrooms = nbBathrooms;
	}
	public boolean isTerrace() {
		return terrace;
	}
	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}
	public float getSurfaceT() {
		return surfaceT;
	}
	public void setSurfaceT(float surfaceT) {
		this.surfaceT = surfaceT;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public ETypePiscine getTypeP() {
		return typeP;
	}
	public void setTypeP(ETypePiscine typeP) {
		this.typeP = typeP;
	}
	public float getSurfaceP() {
		return surfaceP;
	}
	public void setSurfaceP(float surfaceP) {
		this.surfaceP = surfaceP;
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
	public boolean isCave() {
		return cave;
	}
	public void setCave(boolean cave) {
		this.cave = cave;
	}
	public float getSurfaceC() {
		return surfaceC;
	}
	public void setSurfaceC(float surfaceC) {
		this.surfaceC = surfaceC;
	}
	public ETypeCave getTypeCave() {
		return typeCave;
	}
	public void setTypeCave(ETypeCave typeCave) {
		this.typeCave = typeCave;
	}
	public boolean isAlarme() {
		return alarme;
	}
	public void setAlarme(boolean alarme) {
		this.alarme = alarme;
	}
	public boolean isCamSurveillance() {
		return camSurveillance;
	}
	public void setCamSurveillance(boolean camSurveillance) {
		this.camSurveillance = camSurveillance;
	}
	public boolean isCalme() {
		return calme;
	}
	public void setCalme(boolean calme) {
		this.calme = calme;
	}
	public boolean isDependance() {
		return dependance;
	}
	public void setDependance(boolean dependance) {
		this.dependance = dependance;
	}
	public boolean isTraveaux() {
		return traveaux;
	}
	public void setTraveaux(boolean traveaux) {
		this.traveaux = traveaux;
	}
	public EVue getVue() {
		return vue;
	}
	public void setVue(EVue vue) {
		this.vue = vue;
	}
	public EOrientation getOrientation() {
		return orientation;
	}
	public void setOrientation(EOrientation orientation) {
		this.orientation = orientation;
	}
	public EStanding getStanding() {
		return standing;
	}
	public void setStanding(EStanding standing) {
		this.standing = standing;
	}
	public EOrientation[] getOrientations() {
		return EOrientation.values();
	}
	public EVue[] getVues() {
		return EVue.values();
	};
	public ETypeCave[] getTypeCaves() {
		return ETypeCave.values();
	}
	public ETypePiscine[] getTypePiscines() {
		return ETypePiscine.values();
	}
	public EStanding[] getStandings() {
		return EStanding.values();
	}
	
	
	public float getSurfaceAppartement() {
		return surfaceAppartement;
	}
	public void setSurfaceAppartement(float surfaceAppartement) {
		this.surfaceAppartement = surfaceAppartement;
	}
	public int getNbEtageTotal() {
		return nbEtageTotal;
	}
	public void setNbEtageTotal(int nbEtageTotal) {
		this.nbEtageTotal = nbEtageTotal;
	}
	public int getNbEtage() {
		return nbEtage;
	}
	public void setNbEtage(int nbEtage) {
		this.nbEtage = nbEtage;
	}
	public boolean isAscenseur() {
		return ascenseur;
	}
	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}
	public boolean isGardien() {
		return gardien;
	}
	public void setGardien(boolean gardien) {
		this.gardien = gardien;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	public int getSurfaceB() {
		return surfaceB;
	}
	public void setSurfaceB(int surfaceB) {
		this.surfaceB = surfaceB;
	}
	
	////////////////////////////////////////////////////
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	public float getTotal2() {
		return total2;
	}
	public void setTotal2(float total2) {
		this.total2 = total2;
	}
	public float getTotal3() {
		return total3;
	}
	public void setTotal3(float total3) {
		this.total3 = total3;
	}
	public float getTotal4() {
		return total4;
	}
	public void setTotal4(float total4) {
		this.total4 = total4;
	}
	public float getTotal5() {
		return total5;
	}
	public void setTotal5(float total5) {
		this.total5 = total5;
	}
	public float getTotal6() {
		return total6;
	}
	public void setTotal6(float total6) {
		this.total6 = total6;
	}
	public float getTotal7() {
		return total7;
	}
	public void setTotal7(float total7) {
		this.total7 = total7;
	}
	public float getTotal8() {
		return total8;
	}
	public void setTotal8(float total8) {
		this.total8 = total8;
	}
	
	////////////////////////////////////////////////////
	
	
	public float estimerMaison1() {
		total=achatLocationService.EstimationMaison(ville, surfaceTotal, surfaceConstruit,nbNiveaux, nbPiece, nbChambre, nbBathrooms,balcon,surfaceB, terrace, surfaceT, garden, garage, 
				swimmingPool, typeP, surfaceP, airConditioning, heater, cave, surfaceC, typeCave, alarme, camSurveillance,calme,dependance, traveaux, standing, vue, orientation);
	
		return total;	
	}
	
	public float estimerMinMaison() {
		total2=achatLocationService.EstimationMinMaison(ville, surfaceTotal, surfaceConstruit,nbNiveaux, nbPiece, nbChambre, nbBathrooms,balcon,surfaceB, terrace, surfaceT, garden, garage, 
				swimmingPool, typeP, surfaceP, airConditioning, heater, cave, surfaceC, typeCave, alarme, camSurveillance,calme,dependance, traveaux, standing, vue, orientation);
	
		return total2;	
	}
	
	public float estimerMaxMaison() {
		total3=achatLocationService.EstimationMaxMaison(ville, surfaceTotal, surfaceConstruit,nbNiveaux, nbPiece, nbChambre, nbBathrooms,balcon,surfaceB, terrace, surfaceT, garden, garage, 
				swimmingPool, typeP, surfaceP, airConditioning, heater, cave, surfaceC, typeCave, alarme, camSurveillance,calme,dependance, traveaux, standing, vue, orientation);
		return total3;	
	}
	
	public String estimerMaison(){
		estimerMaison1();estimerMinMaison();estimerMaxMaison();
		return "/client/EstimationResult.xhtml?faces-redirect=true";
	}

	public String redirect(){
		clear();
		return "/client/EstimationAccueil.xhtml?faces-redirect=true";
	
	}
	
	public float estimerAppart() {
		total4=achatLocationService.EstimationAppart(ville, surfaceAppartement, nbEtageTotal, nbEtage, ascenseur, gardien, nbPiece, nbChambre, nbBathrooms, balcon, surfaceB, terrace, surfaceT, 
				garden, garage, airConditioning, heater, alarme, camSurveillance, calme,dependance, traveaux, standing,vue, orientation);	
		return total4;	
	}
	
	public float estimerMinAppart() {
		total5=achatLocationService.EstimationAppart(ville, surfaceAppartement, nbEtageTotal, nbEtage, ascenseur, gardien, nbPiece, nbChambre, nbBathrooms, balcon, surfaceB, terrace, surfaceT, 
				garden, garage, airConditioning, heater, alarme, camSurveillance, calme,dependance, traveaux, standing,vue, orientation);	
		return total5;	
	}
	
	public float estimerMaxAppart() {
		total6=achatLocationService.EstimationAppart(ville, surfaceAppartement, nbEtageTotal, nbEtage, ascenseur, gardien, nbPiece, nbChambre, nbBathrooms, balcon, surfaceB, terrace, surfaceT, 
				garden, garage, airConditioning, heater, alarme, camSurveillance, calme,dependance, traveaux, standing,vue, orientation);	
		return total6;	
	}
	
	public String estimerApp(){
		estimerAppart();estimerMinAppart();estimerMaxAppart();
		return "/client/EstimationResult1.xhtml?faces-redirect=true";
	}
	
	public String estimerLoyerAppart() {
		total7=achatLocationService.EstimationLoyerAppart(ville, surfaceAppartement, nbEtageTotal, nbEtage, ascenseur, gardien, nbPiece, 
				nbChambre, nbBathrooms, balcon, terrace, garden, garage, airConditioning, heater, alarme, camSurveillance, calme, dependance, 
				standing, vue, orientation);		
				
				return "/client/EstimationResult3.xhtml?faces-redirect=true";	
	}
	
	public String estimerLoyerMaison() {
		total8=achatLocationService.EstimationMaison(ville, surfaceTotal, surfaceConstruit,nbNiveaux, nbPiece, nbChambre, nbBathrooms,balcon,surfaceB, terrace, surfaceT, garden, garage, 
				swimmingPool, typeP, surfaceP, airConditioning, heater, cave, surfaceC, typeCave, alarme, camSurveillance,calme,dependance, traveaux, standing, vue, orientation);	
		return "/client/EstimationResult2.xhtml?faces-redirect=true";	
	}
	
	public void good(){
		System.out.println("teeeeeeeeeest");
		achatLocationService.goodEstimation();
	}
	public void high(){
		System.out.println("teeeeeeeeeest");
		achatLocationService.highEstimation();
	}
	public void low(){
		System.out.println("teeeeeeeeeest");
		achatLocationService.lowEstimation();
	}
	
	/////////////////////	Redirections	////////////////////////
	
	
	
	public String redirectEstimerM() {
		return "EstimationM.jsf";
	}
	
	public String redirectEstimerApp() {
		return "EstimationApp.jsf";
	}
	public String redirectEstimerML() {
		return "EstimationMLoyer.jsf";
	}
	
	public String redirectEstimerAppL() {
		return "EstimationAppLoyer.jsf";
	}
	
	public String redirectToEst(){
		clear();
		return "/client/EstimationAccueil.xhtml?faces-redirect=true";
	}
	public String redirectToEstLoyer(){
		clear();
		return "/client/EstimationAccueilLoyer.xhtml?faces-redirect=true";
	}
	public String redirectToOtherEstimation(){
		return "/client/EstimationNV.xhtml?faces-redirect=true";
	}
	
	public String redirectToPrices() {
		return "/client/Prices.xhtml?faces-redirect=true";
	}
	
	public String redirectToSold() {
		return "/client/LastSold.xhtml?faces-redirect=true";
		
	}
	
	
	public void clear(){
		this.setVille(null);
		this.setSurfaceTotal(0);this.setSurfaceConstruit(0);
		this.setNbBathrooms(0);this.setNbChambre(0);this.setNbPiece(0);
		this.setNbNiveaux(0);this.setBalcon(false);this.setSurfaceB(0);
		this.setTerrace(false);this.setSurfaceT(0);this.setGarden(false);
		this.setGarage(false);this.setSwimmingPool(false);this.setTypeP(null);
		this.setAirConditioning(false);this.setHeater(false);this.setCave(false);
		this.setSurfaceC(0);this.setTypeCave(null);this.setAlarme(false);
		this.setCamSurveillance(false);this.setCalme(false);this.setDependance(false);
		this.setTraveaux(false);this.setStanding(null);this.setVue(null);this.setOrientation(null);
		this.setNbEtageTotal(0);this.setNbEtage(0);this.setAscenseur(false);this.setGardien(false);this.setSurfaceAppartement(0);
		
	}
	
	
	
}
