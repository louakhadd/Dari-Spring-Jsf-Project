package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.EOrientation;
import tn.esprit.spring.entities.EStanding;
import tn.esprit.spring.entities.ETypeCave;
import tn.esprit.spring.entities.ETypePiscine;
import tn.esprit.spring.entities.EVue;
import tn.esprit.spring.entities.FavoriteAd;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.FavoriteAdService;
import tn.esprit.spring.services.WishListService;

@RestController
public class AchatLocationRestController {
	 @Autowired 
	 WishListService wishListService;
	 @Autowired 
	 FavoriteAdService favoriteAdService;
	 @Autowired 
	AchatLocationService achatLocationService;
	
	/////////////////////// WishList//////////////////////////////////
	 
	    //http://localhost:8081/getWishListById/3
	    @GetMapping(value = "getWishListById/{id}")
	    @ResponseBody
		public WishList getWishListById(@PathVariable("id") String Id) {

			return wishListService.retrieveWishList(Id);
		}

	 
	// localhost:8081/retrieve-all-wishLists
		//GET
	 @GetMapping("/retrieve-all-wishLists") 
	 @ResponseBody 
	 public List<WishList> getWishLists() {
		 List<WishList> list = wishListService.retrieveAllWishLists();
		 return list; } 
	 
 	 // http://localhost:8081/getAllWishListByClient/5
	    @GetMapping(value = "getAllWishListByClient/{idclient}")
	    @ResponseBody
		public List<WishList> getAllWishListByClient(@PathVariable("idclient") int idclient) {
			return wishListService.getAllWhishListsByUser(idclient);
		}
	 
	 
		// localhost:8081/add-wishList
	 @PostMapping("/add-wishList") 
	 @ResponseBody 
	 public WishList addWishList(@RequestBody WishList u) { 
		 WishList user = wishListService.addWishList(u);	
		 return user; 
		 }
	 
	 
	// localhost:8081/remove-wishList/{wishList-id} 
		//DELETE
	 
	 @DeleteMapping("/remove-wishList/{wishList-id}") 
	 @ResponseBody 
	 public void removeWishList(
			 @PathVariable("wishList-id") int userId) { 
		 wishListService.deleteWishList(userId);
	 	}
	 
	// localhost:8081/modify-wishList  
		//PUT
	 @PutMapping("/modify-wishList")
	 @ResponseBody 
	 public WishList modifyWishList(@RequestBody WishList user) { 
		 return wishListService.updateWishList(user);
	 }
	 
 	 // http://localhost:8081/getAllWhishListsByClient/5
	 @GetMapping(value = "getAllWhishListsByClient/{idC}")
	 @ResponseBody
	 public List<WishList> getAllWhishListsByClient(@PathVariable("idC") long idClient) {
		return wishListService.getAllWhishListsByUser(idClient);
	}

	 	/////////////////// Favoris //////////////////////////////////
	 
		// localhost:8081/favoriserAnnonce/1/1
	 @PostMapping("/favoriserAnnonce/{adId}/{idC}") 
	 @ResponseBody 
	 public void favoriserAnnonce(@PathVariable("adId") int adId, @PathVariable("idC") long idC) { 
		 favoriteAdService.favoriserAnnonce(adId,idC);	
		// return user; 
		 }
	 
	 // localhost:8081/remove-favoris/{favoris-id} 
			//DELETE
		 
	 @DeleteMapping("/remove-favoris/{favoris-id}") 
	 @ResponseBody 
	 public void removeFavorisAd(
		 @PathVariable("favoris-id") int userId) { 
		 favoriteAdService.deleteFavorite(userId);
		 	}
		
		    
	 // http://localhost:8081/getAllFavoritesByClient/5
	@GetMapping(value = "getAllFavoritesByClient/{idC}")
	@ResponseBody
	public List<Ad> getAllFavoritesByClient(@PathVariable("idC") long idClient) {
			return favoriteAdService.getAllFavoritesByClient(idClient);
	}
	///////////////////////////////////////Biens Vendus///////////////////////////////////////	
	
	// localhost:8081/retrieve-LastSold
			//GET
	@GetMapping("/retrieve-LastSold") 
	@ResponseBody 
	public List<Ad> getLastSold() {
		 List<Ad> list = achatLocationService.DernierBienVendu();
		 return list; 
	} 
	
		// http://localhost:8081/getAllFavoritesByClient/5
	@GetMapping(value = "getLastSoldByClient/{idC}")
	@ResponseBody
	public List<Ad> getLastSoldByClient(@PathVariable("idC") long idClient) {
			return achatLocationService.BienVenduParClient(idClient);
	}
	
	///////////////////////////////////////Recherche///////////////////////////////////////
	
		//http://localhost:8081/filtreMulticritere/Villa/Tunis/200/800
		 @GetMapping(value = "/filtrePrimaireV/{KindOfGood}/{location}/{budgetMin}/{budgetMax}")
		 public List<Ad> filtrePrimaireV(@PathVariable("KindOfGood") String KindOfGood, @PathVariable("location") String location, @PathVariable("budgetMin") float budgetMin, @PathVariable("budgetMax") float budgetMax) {
				return achatLocationService.RecherchePrimaireV(KindOfGood, location, budgetMin, budgetMax);
		}
		 
		 @GetMapping(value = "/filtrePrimaireA/{KindOfGood}/{location}/{budgetMin}/{budgetMax}")
		 public List<Ad> filtrePrimaireA(@PathVariable("KindOfGood") String KindOfGood, @PathVariable("location") String location, @PathVariable("budgetMin") float budgetMin, @PathVariable("budgetMax") float budgetMax) {
				return achatLocationService.RecherchePrimaireA(KindOfGood, location, budgetMin, budgetMax);
		}

		 //http://localhost:8081/filtreMulticritere/Villa/Tunis/200/800/200/800/5/true/true/true/true/true/true
		@GetMapping(value = "/filtreMulticritere/{KindOfGood}/{location}/{surfaceMin}/{surfaceMax}/{budgetMin}/{budgetMax}/{nbPiece}/{nbChambre}/{nbGarage}/{Terrace}/{SwimmingPool}/{Garden}/{AirConditioning}/{heater}/{sousSol}/{ascenseur}")
		public List<Ad> filtreMulticritèreV(@PathVariable("KindOfGood") String KindOfGood, @PathVariable("location") String location, @PathVariable("surfaceMin") float surfaceMin, @PathVariable("surfaceMax") float surfaceMax, @PathVariable("budgetMin") float budgetMin, @PathVariable("budgetMax") float budgetMax,
				@PathVariable("nbPiece") int nbPiece, @PathVariable("nbChambre") int nbChambre,@PathVariable("nbGarage") int nbGarage, @PathVariable("Terrace") boolean Terrace, @PathVariable("SwimmingPool") boolean SwimmingPool, @PathVariable("Garden") boolean Garden, @PathVariable("AirConditioning") boolean AirConditioning,@PathVariable("heater") boolean heater,@PathVariable("sousSol") boolean sousSol,@PathVariable("ascenseur") boolean ascenseur) {
			return achatLocationService.FiltreMulticritèreV(KindOfGood, location, surfaceMin, surfaceMax, budgetMin, budgetMax, nbPiece, nbChambre,nbGarage, Terrace, SwimmingPool, Garden, AirConditioning, heater, sousSol, ascenseur);
		}
	///////////////////////////////////////Estimation///////////////////////////////////////
		
		 //http://localhost:8081/filtreMulticritere/Ariana/300/250/5/4/2/true/30/false/true/false/null/null/true/true/false/null/null/true/true/false/Dégagé/Sud
		@GetMapping(value = "/Estimation/{Ville}/{surfaceTotal}/{surfaceConstruit}/{nbPiece}/{NbChambre}/{NbBathrooms}/{Terrace}/{surfaceT}/{Garden}/{Garage}/{SwimmingPool}/{TypeP}/{SurfaceP}/{AirConditioning}/{heater}/{cave}/{surfaceC}/{TypeCave}/{Alarme}/{CamSurveillance}/{Traveaux}/{vue}/{orientation}")
		public float Estimation(@PathVariable("Ville") String Ville, @PathVariable("surfaceTotal") float surfaceTotal, @PathVariable("surfaceConstruit") float surfaceConstruit, @PathVariable("nbNiveaux") int nbNiveaux, @PathVariable("nbPiece") int nbPiece, @PathVariable("NbChambre") int NbChambre,@PathVariable("NbBathrooms") int NbBathrooms, 
				@PathVariable("balcon") Boolean balcon, @PathVariable("surfaceB") int surfaceB,@PathVariable("Terrace") Boolean Terrace, @PathVariable("surfaceT") float surfaceT,@PathVariable("Garden") Boolean Garden,@PathVariable("Garage") Boolean Garage,@PathVariable("SwimmingPool") Boolean SwimmingPool, @PathVariable("TypeP") ETypePiscine TypeP,@PathVariable("SurfaceP") float SurfaceP,  
				@PathVariable("AirConditioning") Boolean AirConditioning,@PathVariable("heater") Boolean heater,@PathVariable("cave") Boolean cave,@PathVariable("surfaceC") float surfaceC, @PathVariable("TypeCave") ETypeCave TypeCave,@PathVariable("Alarme") Boolean Alarme, @PathVariable("CamSurveillance") Boolean CamSurveillance, 
				@PathVariable("calme") Boolean calme,@PathVariable("dependance") Boolean dependance,@PathVariable("Traveaux") Boolean Traveaux, @PathVariable("standing") EStanding standing, @PathVariable("vue") EVue vue, @PathVariable("orientation") EOrientation orientation) {
			return achatLocationService.EstimationMaison(Ville, surfaceTotal, surfaceConstruit, nbNiveaux, nbPiece, NbChambre, NbBathrooms, balcon, surfaceB, Terrace, surfaceT, Garden, Garage, SwimmingPool, TypeP, SurfaceP, AirConditioning, heater, cave, surfaceC, TypeCave, Alarme, CamSurveillance, calme, dependance, Traveaux, standing, vue, orientation);
		}
				 
		
		 
				 
}

