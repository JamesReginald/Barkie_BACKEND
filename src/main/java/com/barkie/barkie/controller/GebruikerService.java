package com.barkie.barkie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barkie.barkie.domein.Gebruiker;

@Service
public class GebruikerService {
    @Autowired
    GebruikerRepository gr;
    
    public ResponseEntity<Gebruiker> addGebruiker(Gebruiker newGebruiker) {
    	gr.save(newGebruiker);
    	List<Gebruiker> nieuw = gr.findByGebruikersNaamAndPassword(newGebruiker.getGebruikersNaam(), newGebruiker.getPassword());
    	if(nieuw.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	} else {
    		Gebruiker nieuwGebruiker = nieuw.get(0);
    		return new ResponseEntity<>(nieuwGebruiker, HttpStatus.OK);
    	}
    	
    }

    public ResponseEntity<Gebruiker> getGebruiker(Gebruiker queryGebruiker) {
    	List<Gebruiker> gebruikers = gr.findByGebruikersNaamAndPassword(queryGebruiker.getGebruikersNaam(), queryGebruiker.getPassword());
    	if(gebruikers.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	} else return new ResponseEntity<>(gebruikers.get(0), HttpStatus.OK);
    }
}
