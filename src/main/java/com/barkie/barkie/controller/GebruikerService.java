package com.barkie.barkie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barkie.barkie.domein.Gebruiker;

@Service
public class GebruikerService {
    @Autowired
    GebruikerRepository gr;
    
    public long addGebruiker(Gebruiker newGebruiker) {
    	gr.save(newGebruiker);
    	long newId = gr.findByGebruikersNaamAndPassword(newGebruiker.getGebruikersNaam(), newGebruiker.getPassword())
    	.get(0)
    	.getGebruiker_id();
    	return newId;
    }

    public long getGebruiker(Gebruiker queryGebruiker) {
    	List<Gebruiker> gebruikers = gr.findByGebruikersNaamAndPassword(queryGebruiker.getGebruikersNaam(), queryGebruiker.getPassword());
    	return gebruikers.get(0).getGebruiker_id();
    }
}
