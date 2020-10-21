package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.EOrientation;
import tn.esprit.spring.entities.EStanding;
import tn.esprit.spring.entities.ETypeCave;
import tn.esprit.spring.entities.ETypePiscine;
import tn.esprit.spring.entities.EVue;
import tn.esprit.spring.entities.EstimationAvis;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.PrixParM2;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.repository.EstimationAvisRepository;
import tn.esprit.spring.repository.FavoriteAdRepository;
import tn.esprit.spring.repository.PrixParM2Repository;

@Service
public class AchatLocationServiceImpl implements AchatLocationService {

	public static final Logger L = LogManager.getLogger(AchatLocationServiceImpl.class);
	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	FavoriteAdRepository favoriteAdRepository;
	@Autowired
	IAdService as;
	@Autowired
	AdRepository adRepository;
	@Autowired
	EstimationAvisRepository estRepository;
	@Autowired
	PrixParM2Repository prixRepository;
	@Autowired
	IAdService adService;
	
				/////////////////////////	Séparation Type annonce		////////////////////////////////
	@Override
	public List<Ad> AnnonceVente() {
		// TODO Auto-generated method stub
		List<Ad> list = new ArrayList<>();
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getRentingtype()==null)
			{
				list.add(ad);
			}
		}
		L.info("aaaaaaaaaaaaaaaaa+++"+list);
		return list;
	}

	@Override
	public List<Ad> AnnonceRent() {
		// TODO Auto-generated method stub
		List<Ad> list = new ArrayList<>();
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getRentingtype()==RentingType.RENT)
			{
				list.add(ad);
			}
		}	
		L.info("bbbbbbbbbbbbbbbb+++"+list);
		return list;
	}

	@Override
	public List<Ad> AnnonceRentTemp() {
		// TODO Auto-generated method stub
		List<Ad> list = new ArrayList<>();
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getRentingtype()==RentingType.TEMPORARY_RENTING)
			{
				list.add(ad);
			}
		}	
		return list;
	}

	@Override
	public List<Ad> AnnonceRentHoliday() {
		// TODO Auto-generated method stub
		List<Ad> list = new ArrayList<>();
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getRentingtype()==RentingType.HOLIDAYS_RENTING)
			{
				list.add(ad);
			}
		}	
		return list;
	}

		/////////////////////////	Bien Vendus		////////////////////////////////
	@Override
	public void Archiver(int idAd)
	{
	/*	Ad ad=adService.retrieveAdById(Integer.toString(idAd));
		Date dateAchat=new Date();
		ad.setDateAchat(dateAchat);
		ad.setIdAcheteur(appointmentRepository.lastAppointment(idAd).getClient().getId());
		ad.setState(true);
		adRepository.save(ad);	*/

		Ad ad=adService.retrieveAdById(Integer.toString(idAd));
		Date dateAchat=new Date();
		ad.setDateAchat(dateAchat);
		ad.setIdAcheteur(appointmentRepository.lastAppointment(idAd).getClient().getId());
		ad.setEtat(Etat.Vendu);
		adRepository.save(ad);
		
		
		
	}
	
	@Override
	public List<Ad> DernierBienVendu() {
		// TODO Auto-generated method stub
		List<Ad> vendu = new ArrayList<>();
		for (Ad ad : adRepository.findAll())
		{
			if (ad.getEtat()==Etat.Vendu && ad.getRentingtype()==null)
			{
				vendu.add(ad);
			}
		}
		L.info("AAAAAAAAA+++++++"+vendu);
		return vendu;
	}

	@Override
	public List<Ad> BienVenduParClient(long idClient) {
		// TODO Auto-generated method stub
		List<Ad> vendu = new ArrayList<>();
		for (Ad ad : adRepository.findAll())
		{
			if (ad.getEtat()==Etat.Vendu  && ad.getRentingtype()==null && ad.getIdAcheteur()==idClient)
			{
				vendu.add(ad);
			}
		}
		L.info("AAAAAAAAA+++++++"+vendu);
		return vendu;
	}
	
	
////////////////////     Prix par m2    /////////////////////////////////////
	@Override
	public void RemplissageTablePrix(){
		List<PrixParM2> p = new ArrayList<>();
		PrixParM2 p1 = new PrixParM2(1,"Ariana",1041,1381,800,900,1200,1100,1600,8,9);
		PrixParM2 p2 = new PrixParM2(2,"Bizert",1000,1167,900,1100,1000,1267,0,7,8);
		PrixParM2 p3 = new PrixParM2(3,"Béja",800,961,600,700,900,800,1100,6,7);
		PrixParM2 p4 = new PrixParM2(4,"Ben Arous",938,1043,600,838,1038,943,1143,6,7);
		
		PrixParM2 p5 = new PrixParM2(5,"Gabes",660,638,0,0,0,0,0,0,0);
		PrixParM2 p6 = new PrixParM2(6,"Gafsa",593,822,0,0,0,0,0,0,0);
		PrixParM2 p7 = new PrixParM2(7,"Jendouba",677,943,0,0,0,0,0,0,0);
		PrixParM2 p8 = new PrixParM2(8,"Kairaouen",615,700,0,0,0,0,0,0,0);
		PrixParM2 p9 = new PrixParM2(9,"kasserine",544,785,0,0,0,0,0,0,0);
		PrixParM2 p10 = new PrixParM2(10,"Kebli",520,568,0,0,0,0,0,0,0);
		
		PrixParM2 p11 = new PrixParM2(11,"Kef",473,685,350,380,550,580,790,3,4);
		PrixParM2 p12 = new PrixParM2(12,"Mahdia",747,1075,550,640,800,975,1175,6,6);
		PrixParM2 p13 = new PrixParM2(13,"Manouba",800,900,600,700,900,800,1000,6,7);
		PrixParM2 p14 = new PrixParM2(14,"Medenine",1030,1292,400,900,1100,1100,1300,5,5);		
		PrixParM2 p15 = new PrixParM2(15,"Monastir",900,1200,600,800,1000,1100,1300,6,7);		
		PrixParM2 p16 = new PrixParM2(16,"Nabeul",1100,1300,650,1000,1200,1200,1400,8,7);
		PrixParM2 p17 = new PrixParM2(17,"Sfax",1200,1500,700,1100,1300,1400,1600,7,7);
		PrixParM2 p18 = new PrixParM2(18,"Sidi Bouzid",700,700,450,600,800,600,800,4,5);
		PrixParM2 p19 = new PrixParM2(19,"Siliana",800,750,500,700,900,650,850,4,4);
		PrixParM2 p20 = new PrixParM2(20,"Sousse",1500,1600,750,1400,1600,1500,1700,8,9);
		PrixParM2 p21 = new PrixParM2(21,"Tataouine",700,800,400,600,800,700,900,4,4);
		PrixParM2 p22 = new PrixParM2(22,"Tozeur",552,720,400,500,650,620,820,5,5);
		PrixParM2 p23 = new PrixParM2(33,"Tunis",1500,1600,800,1400,1600,1500,1700,9,9);
		PrixParM2 p24 = new PrixParM2(24,"Zaghouan",800,900,500,700,900,1000,1100,6,7);
		
		
		p.add(p1);p.add(p2);p.add(p3);p.add(p4);p.add(p5);p.add(p6);p.add(p7);p.add(p8);p.add(p9);p.add(p10);p.add(p11);p.add(p12);
		p.add(p13);p.add(p14);p.add(p15);p.add(p16);p.add(p17);p.add(p18);p.add(p19);p.add(p20);p.add(p21);p.add(p22);p.add(p23);p.add(p24);
		prixRepository.saveAll(p);
	}
	
	public List<String> allCities(){
		List<String> cities = new ArrayList<>();
		for(PrixParM2 p : prixRepository.findAll())
		{
			cities.add(p.getVille());
		}
		return cities;
	}

////////////////////Filtre multicritères//////////////////////////////////////
	
	@Override
	public List<Ad> RecherchePrimaireV(String KindOfGood, String location, float budgetMin, float budgetMax)
	{
		List<Ad> searchedAds= new ArrayList<>();
		searchedAds.addAll(adRepository.RecherchePrimaireVente(KindOfGood, location, budgetMin, budgetMax));
		
		L.info("AAAAAAAAAAAAAAAAAAAAAA++++++++++"+searchedAds);
		
		return searchedAds;
	}
	@Override
	public List<Ad> RecherchePrimaireA(String KindOfGood, String location, float budgetMin, float budgetMax)
	{
		List<Ad> searchedAds= new ArrayList<>();
		searchedAds.addAll(adRepository.RecherchePrimaireLocation(KindOfGood, location, budgetMin, budgetMax));
		
		L.info("AAAAAAAAAAAAAAAAAAAAAA++++++++++"+searchedAds);
		
		return searchedAds;
	}

	@Override
	public List<Ad> FiltreMulticritèreV(String KindOfGood, String location, float surfaceMin, float surfaceMax, float budgetMin, float budgetMax,
			int nbBaths, int nbChambre, int nbGarage, Boolean Terrace, Boolean SwimmingPool,Boolean AirConditioning,Boolean heater,Boolean Garden, Boolean sousSol,Boolean ascenseur) {
		// TODO Auto-generated method stub
		
		List<Ad> searchedAds= new ArrayList<>();
		searchedAds.addAll(adRepository.findAdByCriteriaV(KindOfGood, location, nbBaths, nbChambre, budgetMin, budgetMax, surfaceMin, surfaceMax, nbGarage, Terrace, SwimmingPool, AirConditioning, heater, Garden, sousSol, ascenseur));
		
		
		L.info("AAAAAAAAAAAAAAAAAAAAAA++++++++++"+searchedAds);
		L.info("AAAAAAAAAAAAAAAAAAAAAA++++++++++"+searchedAds.size());
		return searchedAds;
	}
	
	@Override
	public List<Ad> FiltreMulticritèreA(String KindOfGood, String location, float surfaceMin, float surfaceMax, float budgetMin, float budgetMax,
			int nbBaths, int nbChambre, int nbGarage, Boolean Terrace, Boolean SwimmingPool,Boolean AirConditioning,Boolean heater, Boolean Garden, Boolean sousSol,Boolean ascenseur, Boolean furnished, String RentingType) {
		// TODO Auto-generated method stub
		
		List<Ad> searchedAds= new ArrayList<>();
		searchedAds.addAll(adRepository.findAdByCriteriaA(KindOfGood, location, nbBaths, nbChambre, budgetMin, budgetMax, surfaceMin, surfaceMax, nbGarage, Terrace, SwimmingPool, AirConditioning, heater, Garden, sousSol, ascenseur, furnished, RentingType));
		
		
		L.info("AAAAAAAAAAAAAAAAAAAAAA++++++++++"+searchedAds);
		return searchedAds;
	}
	
	//////////////////Estimation//////////////////

	@Override
	public float EstimationMaison(String Ville , float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, int NbBathrooms,
			Boolean balcon,int surfaceB ,Boolean Terrace, float surfaceT,Boolean Garden, Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP, 
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave,float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
		//nbniveeaux
			S+= ((surfaceTotal*prixRepository.PrixTerrain(Ville))+(nbNiveaux*(surfaceConstruit*prixRepository.PrixMaison(Ville))));
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Garage){S+=S*0.05;}			//5%
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
						
			if(Terrace){S+=surfaceT*prixRepository.PrixMaison(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixMaison(Ville);}
			if(SwimmingPool)
			{
				if(TypeP==ETypePiscine.Indoor_pool){S+=(SurfaceP*2500);}
				if(TypeP==ETypePiscine.Above_ground_pool){S+=(SurfaceP*1000);}
				if(TypeP==ETypePiscine.Semi_Buried_Pool){S+=(SurfaceP*1500);}
				if(TypeP==ETypePiscine.Inground_pool){S+=(SurfaceP*2000);}  
				if(TypeP==ETypePiscine.Natural_Pool){S+=(SurfaceP*3000);} 
			}
			if(cave)
			{
				if(TypeCave==ETypeCave.Habitable){S+=(surfaceT*prixRepository.PrixMaison(Ville))+500;}
				if(TypeCave==ETypeCave.Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville)+300;}
				if(TypeCave==ETypeCave.Not_Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville);}
				
			}
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre maison est estimé de:+++++++"+S);
		return S;
	}
	
	@Override
	public float EstimationMinMaison(String Ville , float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, int NbBathrooms,
			Boolean balcon,int surfaceB ,Boolean Terrace, float surfaceT,Boolean Garden, Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP, 
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave,float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
		//nbniveeaux
			S+= ((surfaceTotal*prixRepository.PrixTerrain(Ville))+(nbNiveaux*(surfaceConstruit*prixRepository.PrixMinMaison(Ville))));
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Garage){S+=S*0.05;}			//5%
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
						
			if(Terrace){S+=surfaceT*prixRepository.PrixMaison(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixMaison(Ville);}
			if(SwimmingPool)
			{
				if(TypeP==ETypePiscine.Indoor_pool){S+=(SurfaceP*2500);}
				if(TypeP==ETypePiscine.Above_ground_pool){S+=(SurfaceP*1000);}
				if(TypeP==ETypePiscine.Semi_Buried_Pool){S+=(SurfaceP*1500);}
				if(TypeP==ETypePiscine.Inground_pool){S+=(SurfaceP*2000);}  
				if(TypeP==ETypePiscine.Natural_Pool){S+=(SurfaceP*3000);} 
			}
			if(cave)
			{
				if(TypeCave==ETypeCave.Habitable){S+=(surfaceT*prixRepository.PrixMaison(Ville))+500;}
				if(TypeCave==ETypeCave.Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville)+300;}
				if(TypeCave==ETypeCave.Not_Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville);}
				
			}
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre maison est estimé de:+++++++"+S);
		return S;
	}
	
	@Override
	public float EstimationMaxMaison(String Ville , float surfaceTotal, float surfaceConstruit,int nbNiveaux, int nbPiece,int NbChambre, int NbBathrooms,
			Boolean balcon,int surfaceB ,Boolean Terrace, float surfaceT,Boolean Garden, Boolean Garage, Boolean SwimmingPool,ETypePiscine TypeP, 
			float SurfaceP, Boolean AirConditioning,Boolean heater,	Boolean cave,float surfaceC, ETypeCave TypeCave, Boolean Alarme,
			Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
		//nbniveeaux
			S+= ((surfaceTotal*prixRepository.PrixTerrain(Ville))+(nbNiveaux*(surfaceConstruit*prixRepository.PrixMaxMaison(Ville))));
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Garage){S+=S*0.05;}			//5%
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
						
			if(Terrace){S+=surfaceT*prixRepository.PrixMaison(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixMaison(Ville);}
			if(SwimmingPool)
			{
				if(TypeP==ETypePiscine.Indoor_pool){S+=(SurfaceP*2500);}
				if(TypeP==ETypePiscine.Above_ground_pool){S+=(SurfaceP*1000);}
				if(TypeP==ETypePiscine.Semi_Buried_Pool){S+=(SurfaceP*1500);}
				if(TypeP==ETypePiscine.Inground_pool){S+=(SurfaceP*2000);}  
				if(TypeP==ETypePiscine.Natural_Pool){S+=(SurfaceP*3000);} 
			}
			if(cave)
			{
				if(TypeCave==ETypeCave.Habitable){S+=(surfaceT*prixRepository.PrixMaison(Ville))+500;}
				if(TypeCave==ETypeCave.Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville)+300;}
				if(TypeCave==ETypeCave.Not_Convertible){S+=surfaceT*prixRepository.PrixMaison(Ville);}
				
			}
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre maison est estimé de:+++++++"+S);
		return S;
	}
	
	
	@Override
	public float EstimationAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien, int nbPiece, int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,Boolean heater,
			Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
				
			S+= surfaceAppartement*prixRepository.PrixAppart(Ville);
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Parking){S+=S*0.05;}			//0.5
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
			if(Terrace){S+=surfaceT*prixRepository.PrixAppart(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixAppart(Ville);}
			////////////////////////////////////////////////
			if(!ascenseur && nbEtage>3){	S-=S*0.01;	}
			//if(nbEtageTotal){}
			if(gardien){}
			
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre Appart est estimé de:+++++++"+S);
		return S;
	}
	
	@Override
	public float EstimationMinAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien, int nbPiece, int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,Boolean heater,
			Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
				
			S+= surfaceAppartement*prixRepository.PrixMinAppart(Ville);
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Parking){S+=S*0.05;}			//0.5
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
			if(Terrace){S+=surfaceT*prixRepository.PrixAppart(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixAppart(Ville);}
			////////////////////////////////////////////////
			if(!ascenseur && nbEtage>3){	S-=S*0.01;	}
			//if(nbEtageTotal){}
			if(gardien){}
			
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre Appart est estimé de:+++++++"+S);
		return S;
	}
	
	@Override
	public float EstimationMaxAppart(String Ville, float surfaceAppartement,int nbEtageTotal, int nbEtage, Boolean ascenseur,Boolean gardien, int nbPiece, int NbChambre, 
			int NbBathrooms,Boolean balcon,int surfaceB ,Boolean Terrace,float surfaceT,Boolean Garden, Boolean Parking, Boolean AirConditioning,Boolean heater,
			Boolean Alarme,Boolean CamSurveillance,Boolean calme, Boolean dependance, Boolean Traveaux,EStanding standing, EVue vue, EOrientation orientation) {
		// TODO Auto-generated method stub		
		 
		float S=0;
				
			S+= surfaceAppartement*prixRepository.PrixMaxAppart(Ville);
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Parking){S+=S*0.05;}			//0.5
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
			if(Terrace){S+=surfaceT*prixRepository.PrixAppart(Ville);}
			if(balcon){S+=surfaceB*prixRepository.PrixAppart(Ville);}
			////////////////////////////////////////////////
			if(!ascenseur && nbEtage>3){	S-=S*0.01;	}
			if(gardien){}
			
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.1;}			
			if(Traveaux){S-=S*0.1;}			//10%
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre Appart est estimé de:+++++++"+S);
		return S;
	}
	
	

	////////////////////////		Taut d'achat	//////////////////////////////

	@Override //
	public List<Number> Fonction1(){	//proportion des vente/location selon le type du bien
		List<Number> test= new ArrayList<>();
		int a=0; int b=0;
		for(Ad ad :adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getKindofgood()==KindOfGood.Villa)
			{
				a++;
			}
			if(ad.getEtat()== Etat.Vendu && ad.getKindofgood()==KindOfGood.Apartment)
			{
				b++;
			}
		}
		test.add(a);
		test.add(b);
		L.info(test);
		return test;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Number> Fonction2(){  //houses sold per Month
		List<Number> test= new ArrayList<>();
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0;
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getKindofgood()==KindOfGood.Villa)
			{
				if(ad.getDateAchat().getMonth()==0){a++;}
				if(ad.getDateAchat().getMonth()==1){b++;}
				if(ad.getDateAchat().getMonth()==2){c++;}
				if(ad.getDateAchat().getMonth()==3){d++;}
				if(ad.getDateAchat().getMonth()==4){e++;}
				if(ad.getDateAchat().getMonth()==5){f++;}
				if(ad.getDateAchat().getMonth()==6){g++;}
				if(ad.getDateAchat().getMonth()==7){h++;}
				if(ad.getDateAchat().getMonth()==8){i++;}
				if(ad.getDateAchat().getMonth()==9){j++;}
				if(ad.getDateAchat().getMonth()==10){k++;}
				if(ad.getDateAchat().getMonth()==11){l++;}
			}
		}
		test.add(a);test.add(b);test.add(c);test.add(d);test.add(e);test.add(f);
		test.add(g);test.add(h);test.add(i);test.add(j);test.add(k);test.add(l);
		return test;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Number> Fonction3(){ //Apartments sold per Month
		List<Number> test= new ArrayList<>();
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0;
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getKindofgood()==KindOfGood.Apartment)
			{
				if(ad.getDateAchat().getMonth()==0){a++;}
				if(ad.getDateAchat().getMonth()==1){b++;}
				if(ad.getDateAchat().getMonth()==2){c++;}
				if(ad.getDateAchat().getMonth()==3){d++;}
				if(ad.getDateAchat().getMonth()==4){e++;}
				if(ad.getDateAchat().getMonth()==5){f++;}
				if(ad.getDateAchat().getMonth()==6){g++;}
				if(ad.getDateAchat().getMonth()==7){h++;}
				if(ad.getDateAchat().getMonth()==8){i++;}
				if(ad.getDateAchat().getMonth()==9){j++;}
				if(ad.getDateAchat().getMonth()==10){k++;}
				if(ad.getDateAchat().getMonth()==11){l++;}
			}
		}
		test.add(a);test.add(b);test.add(c);test.add(d);test.add(e);test.add(f);
		test.add(g);test.add(h);test.add(i);test.add(j);test.add(k);test.add(l);
		return test;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<Number> Fonction5(){
		List<Number> test= new ArrayList<>();
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0;
		for(Ad ad : adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getKindofgood()==KindOfGood.Villa)
			{
				if(ad.getDateAchat().getMonth()==0){a++;}
				if(ad.getDateAchat().getMonth()==1){b++;}
				if(ad.getDateAchat().getMonth()==2){c++;}
				if(ad.getDateAchat().getMonth()==3){d++;}
				if(ad.getDateAchat().getMonth()==4){e++;}
				if(ad.getDateAchat().getMonth()==5){f++;}
				if(ad.getDateAchat().getMonth()==6){g++;}
				if(ad.getDateAchat().getMonth()==7){h++;}
				if(ad.getDateAchat().getMonth()==8){i++;}
				if(ad.getDateAchat().getMonth()==9){j++;}
				if(ad.getDateAchat().getMonth()==10){k++;}
				if(ad.getDateAchat().getMonth()==11){l++;}
			}
		}
		test.add(a);test.add(b);test.add(c);test.add(d);test.add(e);test.add(f);
		test.add(g);test.add(h);test.add(i);test.add(j);test.add(k);test.add(l);
		return test;
	}
	
	@Override
	public List<Number> Fonction4(){ //pourcentage vente/location
		List<Number> test= new ArrayList<>();
		int a=0; int b=0;
		for(Ad ad :adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getRentingtype()==null){a++;}
			if(ad.getEtat()== Etat.Vendu && ad.getRentingtype()!=null){ b++; }
		}
		test.add(a); test.add(b);
		return test;
	}
	
	@Override
	public List<Number> Fonction6(){ //pourcentage annonce Rent/
		List<Number> test= new ArrayList<>();
		int a=0, b=0, c=0;
		for(Ad ad :adRepository.findAll())
		{
			if(ad.getEtat()== Etat.Vendu && ad.getRentingtype()==RentingType.RENT){ a++;}
			if(ad.getEtat()== Etat.Vendu && ad.getRentingtype()==RentingType.HOLIDAYS_RENTING){ b++;}
			if(ad.getEtat()== Etat.Vendu && ad.getRentingtype()==RentingType.TEMPORARY_RENTING){ c++;}
		}
		test.add(a);test.add(b);test.add(c);
		return test;
	}

	
	
	////////////////////////////////// JSF ////////////////////////////////////////////////////////
	@Override 
	public List<PrixParM2> getAllPrices() { 
		return (List<PrixParM2>)prixRepository.findAll(); 
	}

	@Override
	public float EstimationLoyerMaison(String Ville, float surfaceTotal, float surfaceConstruit, int nbNiveaux,
			int nbPiece, int NbChambre, int NbBathrooms, Boolean balcon, Boolean Terrace, Boolean Garden,
			Boolean Garage, Boolean SwimmingPool, Boolean AirConditioning, Boolean heater, Boolean cave, Boolean Alarme,
			Boolean CamSurveillance, Boolean calme, Boolean dependance, EStanding standing, EVue vue,
			EOrientation orientation) {
		// TODO Auto-generated method stub
		float S=0;
		//nbniveeaux
			S+= ((surfaceTotal*prixRepository.PrixTerrain(Ville))+(nbNiveaux*(surfaceConstruit*prixRepository.PrixMaxMaison(Ville))));
			if(NbChambre>=5){S+=S*0.02;}	//2%		
			if(nbPiece>=5){S+=S*0.05;}		//5% 
			if(NbBathrooms>=2){S+=S*0.05;}	//5%
			if(Garage){S+=S*0.05;}			//5%
			if(AirConditioning){S+=S*0.02;}	//2%   
			if(heater){S+=S*0.03;}			//3%
			if(Alarme){S+=S*0.01;}			//2%
			if(CamSurveillance){S+=S*0.02;}	//2%	
						
			if(Terrace){S+=S*0.2;}
			if(balcon){S+=S*0.2;}
			
			if(SwimmingPool){S+=S*0.7;}		//7%
			if(cave){S+=S*0.5;}				//5%
			
			if(dependance){ S-=S*0.05; } //5%
			if(!calme){S-=S*0.2;}			//2%	
			if(standing==EStanding.Medium){S+=S*0.1;} //10
			if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
			if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
			if(vue==EVue.Clear){S+=S*0.07;}		//7%
			if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
			if(vue==EVue.Face_To_Face){S-=S*0.01;}	
			if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
			if(orientation==EOrientation.West){S+=S*0.05;}	//5%
			if(orientation==EOrientation.North){}
		
		
		L.info("Votre maison est estimé de:+++++++"+S);
		return S;
	}

	@Override
	public float EstimationLoyerAppart(String Ville, float surfaceAppartement, int nbEtageTotal, int nbEtage,
			Boolean ascenseur, Boolean gardien, int nbPiece, int NbChambre, int NbBathrooms, Boolean balcon,
			Boolean Terrace, Boolean Garden, Boolean Parking, Boolean AirConditioning, Boolean heater, Boolean Alarme,
			Boolean CamSurveillance, Boolean calme, Boolean dependance, EStanding standing, EVue vue,
			EOrientation orientation) {
		// TODO Auto-generated method stub
		float S=0;
		
		S+= surfaceAppartement*prixRepository.PrixMinAppart(Ville);
		if(NbChambre>=5){S+=S*0.02;}	//2%		
		if(nbPiece>=5){S+=S*0.05;}		//5% 
		if(NbBathrooms>=2){S+=S*0.05;}	//5%
		if(Parking){S+=S*0.05;}			//0.5
		if(AirConditioning){S+=S*0.02;}	//2%   
		if(heater){S+=S*0.03;}			//3%
		if(Alarme){S+=S*0.01;}			//1%
		if(CamSurveillance){S+=S*0.02;}	//2%	
		if(Terrace){S+=S*0.2;}
		if(balcon){S+=S*0.2;}
		////////////////////////////////////////////////
		if(!ascenseur && nbEtage>3){	S-=S*0.01;	}
		//if(nbEtageTotal){}
		if(gardien){}
		
		if(dependance){ S-=S*0.05; } //5%
		if(!calme){S-=S*0.1;}			
		if(standing==EStanding.Medium){S+=S*0.1;} //10
		if(standing==EStanding.High_Standing){S+=S*0.2;}		//20-	
		if(standing==EStanding.Very_High_Standing){S+=S*0.3;}		//30						
		if(vue==EVue.Clear){S+=S*0.07;}		//7%
		if(vue==EVue.Exceptional){S+=S*0.15;}	//15%
		if(vue==EVue.Face_To_Face){S-=S*0.01;}	
		if(orientation==EOrientation.South || orientation==EOrientation.East){S+=S*0.07;}	//1%
		if(orientation==EOrientation.West){S+=S*0.05;}	//5%
		if(orientation==EOrientation.North){}
	
	
	L.info("Votre Appart est estimé de:+++++++"+S);
	return S;
	}

	@Override
	public void goodEstimation() {
		// TODO Auto-generated method stub
		int n = 0;

		for (EstimationAvis ea : estRepository.findAll()) {
			
				n = estRepository.getGoodOpinion();
				n++;
				ea.setGood(n);
				
			estRepository.save(ea);
		}
		
	}

	@Override
	public void highEstimation() {
		// TODO Auto-generated method stub
		int n = 0;

		for (EstimationAvis ea : estRepository.findAll()) {
			
				n = estRepository.getHighOpinion();
				n++;
				ea.setHigh(n);
				
			estRepository.save(ea);
		}
	}

	@Override
	public void lowEstimation() {
		// TODO Auto-generated method stub
		int n = 0;

		for (EstimationAvis ea : estRepository.findAll()) {
			
				n = estRepository.getLowOpinion();
				n++;
				ea.setLow(n);
				
			estRepository.save(ea);
		}
	}
	
	@Override //
	public List<Number> Fonction7(){	//proportion des vente/location selon le type du bien
		List<Number> test= new ArrayList<>();
		int a=0; int b=0; int c=0;
		
		for(EstimationAvis ea :estRepository.findAll())
		{
				a=ea.getLow();b=ea.getGood();c=ea.getHigh();
			
		}
		test.add(a);
		test.add(b);
		test.add(c);
		L.info(test);
		return test;
	}



	@Override	
	public PrixParM2 addPrix(PrixParM2 p) {
		// TODO Auto-generated method stub
		return prixRepository.save(p);
	}

	@Override
	public PrixParM2 updatePrix(PrixParM2 p) {
		// TODO Auto-generated method stub
		return prixRepository.save(p);
	}
	
	@Override
	public int addOrUpdate(PrixParM2 p){
		prixRepository.save(p);
		return p.getId();
	}
	
	

}

	
