package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long IdF;  
	@ManyToOne(cascade = CascadeType.ALL) 
	User Follow;
	@ManyToOne(cascade = CascadeType.ALL) 
	User Followed;
	public Follow(Long id, User follow, User followed) {
		super();
		this.IdF = id;
		Follow = follow;
		Followed = followed;
	}
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Follow [id=" + IdF + ", Follow=" + Follow + ", Followed=" + Followed + "]";
	}
	public Long getId() {
		return IdF;
	}
	public void setId(Long id) {
		this.IdF = id;
	}
	public User getFollow() {
		return Follow;
	}
	public void setFollow(User follow) {
		Follow = follow;
	}
	public User getFollowed() {
		return Followed;
	}
	public void setFollowed(User followed) {
		Followed = followed;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Follow == null) ? 0 : Follow.hashCode());
		result = prime * result + ((Followed == null) ? 0 : Followed.hashCode());
		result = prime * result + ((IdF == null) ? 0 : IdF.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follow other = (Follow) obj;
		if (Follow == null) {
			if (other.Follow != null)
				return false;
		} else if (!Follow.equals(other.Follow))
			return false;
		if (Followed == null) {
			if (other.Followed != null)
				return false;
		} else if (!Followed.equals(other.Followed))
			return false;
		if (IdF == null) {
			if (other.IdF != null)
				return false;
		} else if (!IdF.equals(other.IdF))
			return false;
		return true;
	}
	
}
