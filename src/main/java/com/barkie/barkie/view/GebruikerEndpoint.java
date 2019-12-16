package com.barkie.barkie.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barkie.barkie.controller.GebruikerService;
import com.barkie.barkie.domein.Gebruiker;

@RestController
public class GebruikerEndpoint {
	@Autowired
    GebruikerService gs;
	
	@PostMapping("gebruiker/create")
	public ResponseEntity<Gebruiker> setGebruiker(@RequestBody Gebruiker newGebruiker) {
		return gs.addGebruiker(newGebruiker);
	}
	
	@PostMapping("gebruiker/login")
	public ResponseEntity<Gebruiker> getGebruiker(@RequestBody Gebruiker queryGebruiker) {
		return gs.getGebruiker(queryGebruiker);
	}
	
}
