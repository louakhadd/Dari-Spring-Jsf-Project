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
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.services.IAdService;

@RestController
public class RestControlAd {
	@Autowired
	IAdService iadService;
	
		
	// localhost:8081/retrieve-all-ads
	//GET
	@GetMapping("/retrieve-all-ads") 
	@ResponseBody 
	public List<Ad> getAds() { 
		List<Ad> list = iadService.retrieveAllAds(); 
		return list;  } 

	// localhost:8081/getAdById-ad/{ad-id} 
	//GET
	@GetMapping("/getAdById-ad/{ad-id}") 
	@ResponseBody  
	public Ad getAdById
	(@PathVariable("ad-id") int adId) {
		return iadService.getAdById(adId);} 

	// Ajouter AD : 
	// localhost:8081/add-ad
	//POST
	/*{
    "kindofgood": null,
    "comments": [],
    "multimedias": null,
    "location": null,
    "description": null,
    "area": 0,
    "idAd": 7,
    "adDate": null,
    "success": null,
    "score": 0,
    "viewsNumber": 0
}*/
	@PostMapping("/add-ad") 
	@ResponseBody 
	public Ad addAd(@RequestBody Ad ad) { 
		iadService.addAd(ad); 
		return ad; }

	// /localhost:8081/remove-ad/{ad-id} 
	//DELETE
	@DeleteMapping("/remove-ad/{ad-id}") 
	@ResponseBody 
	public void removeAd(@PathVariable("ad-id") int adId) { 
		iadService.deleteAd(adId);}  

	//////////////////////////////////////////////////////////COMMENT/////////////////////////////////////////////////////////////////////////////////////
	// Ajouter Comment : 
	// localhost:8081/add-comment
	//POST

	@PostMapping("/add-comment") 
	@ResponseBody 
	public Comment addComment(@RequestBody Comment comment) { 
		iadService.addComment(comment); 
		return comment; }

	// localhost:8081/modify-ad  
	//PUT
	@PutMapping("/modify-ad") 
	@ResponseBody 
	public Ad modifyAd(@RequestBody Ad ad) 
	{ 	return iadService.updateAd(ad); }

	// /localhost:8081/remove-comment/{comment-id} 
	//DELETE
	@DeleteMapping("/remove-comment/{comment-id}") 
	@ResponseBody 
	public void removeComment(@PathVariable("comment-id") int commentId) { 
		iadService.deleteComment(commentId);}  

	// localhost:8081/modify-comment  
	//PUT
	@PutMapping("/modify-comment") @ResponseBody 
	public Comment modifyComment(@RequestBody Comment comment) { 
		return iadService.UpdateComment(comment); }


	// http://localhost:8081/AssignCommentToanAd/1/1
	@PutMapping(value = "/AssignCommentToanAd/{idcomment}/{idad}") 
	public void AssignCommentToanAd(@PathVariable("idcomment")int CommentId, @PathVariable("idad")int AdId) {
		iadService.AssignCommentToanAd(CommentId, AdId); 
	}



	// http://localhost:8081/getAllCommentsByAd/1
	@GetMapping(value = "getAllCommentsByAd/{idad}")
	@ResponseBody
	public List<String> getAllCommentsByAd (@PathVariable("idad") int AdId) {
		return iadService.getAllCommentsByAd(AdId);
	}

	
}

