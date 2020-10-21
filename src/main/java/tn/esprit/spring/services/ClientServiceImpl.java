package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	public static final Logger L = LogManager.getLogger(ClientServiceImpl.class);

	@Autowired
	ClientRepository clientRepository;
	
	
	
	@Override
	public Client retrieveClient(String id) {
		// TODO Auto-generated method stub
		Client u= clientRepository.findById(Long.parseLong(id)).orElse(null);
		L.info("retrive user by id ++++:"+u);
		return u;
				
	}



	
	
}
