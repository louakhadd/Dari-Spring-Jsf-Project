package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{ 
	@Query("SELECT count(*) FROM Comment c where c.Ads=:idad")
    public int countCommentsJPQL(@Param("idad")int IdAd);
	@Query("SELECT c FROM Comment c Where c.IsBlocked=true")
	List<Comment> retrieveAllBadCommentByClient();
	
	@Query(value="SELECT * FROM `t_comment` c JOIN `t_ad` a ON c.`ads_id_ad`=a.id_ad where a.id_ad=:idc ",nativeQuery = true)
	public List<Comment> DescriptionComments(@Param("idc")int idc);

}
