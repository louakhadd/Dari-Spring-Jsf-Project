package tn.esprit.spring.services;



import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;


public interface UserService {
	public void ajouterClient(Client client);
	public void ajouterAdmin(Admin admin);
	public String authentification(String email,String password);
	public User findUserwithId(long id) ;
	public List<Client> retrieveAllUsers();
	public List<Ad> retrouveannoncesuivit(String Id);
	public String changerPassword(String id, String OldPassword, String password,String newPassword);
	public String depblockCompte(String email);
	public User authentification2(String email,String password);
	public List<User> allUser();
}
