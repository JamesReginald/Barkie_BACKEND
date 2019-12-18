package com.barkie.barkie.controller.service;

import java.util.List;

import com.barkie.barkie.controller.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barkie.barkie.domein.Gebruiker;

@Service
public class GebruikerService {
    @Autowired
	private GebruikerRepository gr;
    
    public ResponseEntity<Gebruiker> addGebruiker(Gebruiker newGebruiker) {
    	List<Gebruiker> naamBezet = gr.findByGebruikersNaam(newGebruiker.getGebruikersNaam());
    	if (naamBezet.isEmpty()) {
    		Gebruiker toegevoegd = gr.save(newGebruiker);
    		return new ResponseEntity<>(toegevoegd, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	}
    }

    public ResponseEntity<Gebruiker> getGebruiker(Gebruiker queryGebruiker) {
    	List<Gebruiker> gebruikers = gr.findByGebruikersNaamAndPassword(queryGebruiker.getGebruikersNaam(), queryGebruiker.getPassword());
    	if(gebruikers.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	} else return new ResponseEntity<>(gebruikers.get(0), HttpStatus.OK);
    }
}
