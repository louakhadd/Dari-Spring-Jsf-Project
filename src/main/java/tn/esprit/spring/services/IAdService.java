package tn.esprit.spring.services;

import java.util.List;


//import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;

public interface IAdService {
	Ad addAd(Ad ad);
	Comment addComment(Comment comment);
	List<Ad> retrieveAllAds();
	void deleteAd(int id); 
	Ad updateAd(Ad ad); 
	Ad getAdById(int adId);
	List<String> getAllCommentsByAd(int AdId);
	public void deleteComment(int commentId);
	
	Comment UpdateComment(Comment comment);
	void AssignCommentToanAd(int CommentId, int AdId);
	public int countComments();
	public double  countAds();
	public List<Ad> getAdWithBestLikesOnCommentsJPQL();
	public int nbrLike();
	public boolean succes();
	public int maxnblike();
	public double AVG_nbcomment();
	public boolean BlockCommentsWithInsultingWords();
	public void BlockCommentsWithInsultingWords3(int id);
	public void ScoreIncrement();
	public int AdsForToday();
	public double AVG_Ads_Year();
	public List<String> getAdsFromTheSameUserJPQL();
	public List<String> getAllCommentsBlockedJPQL();
	public int countCommentsJPQL(int IdAd);
	public int addOrUpdateAd(Ad ad);
	public int getNumberView(int idad);
	public boolean increment(int idad);
	public boolean BlockCommentsWithInsultingWords2(int id);
	public void BlockUserByBadComments();
	List<Comment> retrieveAllComments();
	public List<Ad> filter();
	public Comment getCommentById(int comId);
	public List<Comment> DescriptionComments(int idc);
	public String Image();
	public boolean incrementdislike(int id);
	public boolean incrementlike(int id);
	public int addOrUpdateComment(Comment comment);
	public int nbrDislikeAd();
	public int nbrLikeAd();
	
	
	
	
	//loua
	Ad retrieveAdById(String id);

}
