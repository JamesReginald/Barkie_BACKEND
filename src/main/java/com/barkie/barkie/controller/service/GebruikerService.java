package com.barkie.barkie.controller.service;

import java.util.List;
import java.util.Optional;

import com.barkie.barkie.controller.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barkie.barkie.domein.Gebruiker;

@Service
public class GebruikerService extends DefaultService<Gebruiker> {

	/** GebruikerRepository object to persist Gebruiker objects */
	private final GebruikerRepository gr;

	@Autowired
	public GebruikerService(GebruikerRepository gebruikerRepository) {
		super(gebruikerRepository);
		this.gr = gebruikerRepository;
	}

	public ResponseEntity<Gebruiker> getGebruiker(Gebruiker queryGebruiker) {
    	List<Gebruiker> gebruikers = gr.findByUsernameAndPassword(queryGebruiker.getUsername(), queryGebruiker.getPassword());
    	if(gebruikers.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	} else return new ResponseEntity<>(gebruikers.get(0), HttpStatus.OK);
    }

	/**
	 * This method is quering the database to check if a user exists with the provided username argument
	 * @param naam String representation of the username
	 * @return Gebruiker object
	 */
	public Gebruiker getGebruikerFromNaam(String naam) {
		Optional<Gebruiker> optionalGebruikerBezet = gr.findByUsername(naam);
		if (optionalGebruikerBezet.isPresent()) {
			return optionalGebruikerBezet.get();
		}
		return null;
	}
}
