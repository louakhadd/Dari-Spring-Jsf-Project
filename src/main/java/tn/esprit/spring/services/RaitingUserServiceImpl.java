package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.raitingUser;
import tn.esprit.spring.repository.RaitingUserRepository;

@Service
public class RaitingUserServiceImpl implements RaitingUserService {
	@Autowired
	RaitingUserRepository raitingUserRepository;

	@Override
	public String addRate(String IDConnecte, String IdRate, int nbretoile) {
		Long Idcon = Long.parseLong(IDConnecte);

		Long IdRa = Long.parseLong(IdRate);
		raitingUser raiting = new raitingUser();
		raiting = raitingUserRepository.findRaiting(Idcon, IdRa);
		if (nbretoile > 5) {
			return "max 5";
		}
		if (raiting == null) {
			raitingUserRepository.Insertrate(nbretoile, Idcon, IdRa);
			return "rate ajoute avec succes";
		} else {
			raiting.setNbretoile(nbretoile);
			raitingUserRepository.save(raiting);
			return "raiting update";
		}

	}

	@Override
	public String moyenneRaiting(String IDConnecte) {
		Long Idcon = Long.parseLong(IDConnecte);
		List<raitingUser> Raitings=raitingUserRepository.findRaitingwithConnctUser(Idcon);
		if(Raitings==null) {
			return "you dont have any raiting";
		}
		int x=1;
		int y=1;
		for (raitingUser user : Raitings) {
			
			y=y+1;
			x=x+user.getNbretoile();
			
			
		}
		int moy=x%y;
		return "Moyen d'etoile = "+moy;
	}

}
