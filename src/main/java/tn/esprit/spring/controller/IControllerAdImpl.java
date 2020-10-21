package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.services.IAdService;

@Controller 
public class IControllerAdImpl {
	@Autowired
	IAdService iadService;
	
	

	public Ad addAd(@RequestBody Ad ad) { 
		Ad a = iadService.addAd(ad); 
		return a; }


	public List<Ad> getAds() { 
		List<Ad> list = iadService.retrieveAllAds(); 
		return list;  } 



	public void removeAd(@PathVariable("ad-id") int adId) { 
		iadService.deleteAd(adId);}  


	public Ad modifyAd(@RequestBody Ad ad) { 
		return iadService.updateAd(ad); }

	public Ad getAdById(int adId) {
		return iadService.getAdById(adId);}



	public Comment addComment(Comment comment) {
		return iadService.addComment(comment);

	}

	public void deleteComment(@PathVariable("comment-id")int comId) {
		iadService.deleteComment(comId);
	}

	public Comment UpdateComment(@RequestBody Comment comment) {
		return iadService.UpdateComment(comment);}

	public void AssignCommentToanAd(int CommentId, int AdId) {

		iadService.AssignCommentToanAd(CommentId, AdId);
	}

	public List<String> getAllCommentsByAd(int AdId)  {
		return iadService.getAllCommentsByAd(AdId);
	}

	
}

