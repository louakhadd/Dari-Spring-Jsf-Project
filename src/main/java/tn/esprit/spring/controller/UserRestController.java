package tn.esprit.spring.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.agent;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserService;


@Scope(value = "session")
@Controller(value = "UserRestController")
@ELBeanName(value = "UserRestController")
@Join(path = "/", to = "/login.jsf")
@RestController
public class UserRestController {
	
/*	@Autowired	
	CryptWithMD5 cryptWithMD5;
	@Autowired
	private NotificationServeur notificationServeur;	*/
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdRepository adRepository;
/*	@Autowired
	RaitingUserServiceImpl raitingUserServiceImpl;
	@Autowired
	FollowServiceImpl followServiceImpl;	*/
	@Autowired
	ClientRepository clientRepository;
	

	private String oldPassword;
	private String newPassword;
	private String verifPassword;
	static Client ClientConnecte;
	private Long id;
	private String firstname;
	private String lastname;
	private Date dateNaissance;
	private Client client;
	private User user;
	private String email;
	private String password;
	private boolean loggedIn;
	private String login;
	private String picture;
	private String descriptionBlock;
	private boolean block;
	private List<Client> users;
	private String rate;
	private List<Client> allUser;
	private Client inviteClient;
	private Long idInvite;
	static User Blokeduser;

	

	public static User getBlokeduser() {
		return Blokeduser;
	}

	public static void setBlokeduser(User blokeduser) {
		Blokeduser = blokeduser;
	}

	public Long getIdInvite() {
		return idInvite;
	}

	public void setIdInvite(Long idInvite) {
		this.idInvite = idInvite;
	}

	public Client getInviteClient() {
		return inviteClient;
	}

	public void setInviteClient(Client inviteClient) {
		this.inviteClient = inviteClient;
	}

	public List<Client> getAllUser() {
		return userService.retrieveAllUsers();
	}

	public void setAllUser(List<Client> allUser) {
		this.allUser = allUser;
	}

	public String getVerifPassword() {
		return verifPassword;
	}

	public void setVerifPassword(String verifPassword) {
		this.verifPassword = verifPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public static Client getClientConnecte() {
		return ClientConnecte;
	}

	public static void setClientConnecte(Client clientConnecte) {
		ClientConnecte = clientConnecte;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescriptionBlock() {
		return descriptionBlock;
	}

	public void setDescriptionBlock(String descriptionBlock) {
		this.descriptionBlock = descriptionBlock;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@GetMapping("/retrieve-all-users")
	@ResponseBody
	// http://localhost:8081/retrieve-all-users
	public List<Client> getUsers() {
		List<Client> users = userService.retrieveAllUsers();
		return users;
	}

	@GetMapping("/count")
	@ResponseBody
	// http://localhost:8081/count
	public int getnombre() {
		return userRepository.retrieveUsers();

	}
/*
	@GetMapping("/getAnnoncefollower/{userId}")
	@ResponseBody
	// http://localhost:8081/getAnnoncefollower
	public List<Ad> getAnnoncefollower(@PathVariable("userId") Long userId) {
		return adRepository.affFollow(userId);

	}
*/
	@GetMapping("/authentification/{email}/{password}")
	@ResponseBody
	// http://localhost:8081/getAnnoncefollower
	public String authentification(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.authentification(email, password);

	}

	// @PutMapping("/changepassword/{IDUSer}/{oldPassword}/{newPassword}")
	// @ResponseBody
	// http://localhost:8081/changepassword/29/kjkjk/u
	// public String changepassword(@PathVariable("IDUSer") String IDUSer,
	// @PathVariable("oldPassword") String oldPassword,
	// @PathVariable("newPassword") String newPassword) {
	// return userService.changerPassword(IDUSer, oldPassword, newPassword);
	// }

	@GetMapping("/depblockCompte/{email}")
	@ResponseBody
	// http://localhost:8081/depblockCompte
	public String depblockCompte(@PathVariable("email") String email) {
		// return email;
		return userService.depblockCompte(email);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String doLogin() {
		System.out.println("dddddddddddd");
		String navigateTo = "null";
		User user = userService.authentification2(email, password);
		if (user != null) {
			if (user instanceof Admin) {
				// System.out.println();
				navigateTo = "/client/PricesAdmin.xhtml?faces-redirect=true";
				loggedIn = true;

			} else if (user instanceof Client) {
				if (((Client) user).isBlock()) {
					if(((Client) user).getDescriptionBlock().equals("security problem")) {
						this.Blokeduser = user;
						System.out.println("ooooo"+this.Blokeduser);
						navigateTo = "/pages/client/block.xhtml?faces-redirect=true";
						loggedIn = true;
						this.user = user;

						this.client = ((Client) user);
					}
					

				} else {
					navigateTo = "/client/Accueil.xhtml?faces-redirect=true";
					this.ClientConnecte = ((Client) user);
					this.user = user;
					System.out.println(ClientConnecte);
					System.out.println(user);
					loggedIn = true;

				}

			} else if (user instanceof agent) {
				navigateTo = "/client/Accueil.xhtml?faces-redirect=true";
				loggedIn = true;

			}

		} else {
			FacesMessage facesMessage = new FacesMessage(
					"Login Failed: please check your username/password and try again.");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;

	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
/*
	public String getmoyen(String id) {
		return raitingUserServiceImpl.moyenneRaiting(id);
	}
	public int getmoyenvalue(Long id) {
		return raitingUserServiceImpl.moyenneRaiting(id);
	}
*/
	public void changepassword2() {
		String a = userService.changerPassword(this.user.getId() + "", oldPassword, verifPassword, newPassword);
		FacesMessage facesMessage = new FacesMessage(a);
		FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
	}
/*
	public String addClient() {
		String end = signupsucces2(firstname, lastname, email, dateNaissance);
		FacesMessage facesMessage = new FacesMessage(end);
		FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		if (end.equals("tnak you for your registration")) {
			return "/uploadview.xhtml?faces-redirect=true";
		} else {
			return null;
		}

	}*/
/*
	public String signupsucces2(String nom, String prenom, String email, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

		int existe = 0;
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String end = "tnak you for your registration";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {
			end = "invalide email";
		} else {

			Client u = new Client(null, "Malek", "Hamida", date, "oussama.boubaker@esprit.tn", null, null,
					"oussama.jpg", "nothing", 0, false);

			List<User> users = (List<User>) userRepository.findAll();
			for (User user : users) {
				if (user.getEmail().equals(email)) {
					existe = existe + 1;
				}
			}
			if (existe == 0) {

				u.setFirstName(nom);
				u.setLastname(prenom);
				u.setEmail(email);
				userRepository.save(u);
				notificationServeur.sendNotification(u);
				

			
				client = u;
			} else {
				end = "you have already an accompte";
			}

		}

		return (end);
	}*/

/*	public void forgetPassword() {
		String em=getEmail();
		System.out.println(em);
		String result = userService.forgetPassword(em);
		FacesMessage facesMessage = new FacesMessage(result);
		FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);

	}
	public String afficherProfile(Long id) { 
		String navigateTo = "null";
		inviteClient=null;
		idInvite=id;
		System.out.println(id);
		inviteClient=userService.afficherProfile(id);
		navigateTo = "/pages/client/profileUser.xhtml?faces-redirect=true";
		
		System.out.println(""+inviteClient);
		return navigateTo;
		
	}*/
	public String checkBloked(Client id) {
		
		
			
				if(id.isBlock()){
					return "deBloked compte";
					
				}else {
					return"Bloked compte";
				}
	
	}
	public void Blokedforce(Client client) {
		if(client.isBlock()) {
			client.setBlock(false);
			client.setDescriptionBlock(null);
		}else {
			client.setBlock(true);
			client.setDescriptionBlock("you are bloked from the admin");
		}
		
		clientRepository.save(client);
		
	}

}
