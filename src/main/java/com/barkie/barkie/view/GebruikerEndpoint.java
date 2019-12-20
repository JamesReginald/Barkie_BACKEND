package com.barkie.barkie.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barkie.barkie.controller.service.GebruikerService;
import com.barkie.barkie.domein.Gebruiker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class GebruikerEndpoint {

	@Autowired
    GebruikerService gs;
	
	@PostMapping("gebruiker/create")
	public ResponseEntity<Gebruiker> setGebruiker(@RequestBody Gebruiker newGebruiker) {
		if (gs.getGebruikerFromNaam(newGebruiker.getGebruikersNaam()) == null) {
			return new ResponseEntity<>(gs.save(newGebruiker), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("gebruiker/login")
	public ResponseEntity<Gebruiker> getGebruiker(@RequestBody Gebruiker queryGebruiker) {
		return gs.getGebruiker(queryGebruiker);
	}

	@GetMapping("gebruiker/")
	public List<Gebruiker> getAllGebruikers() {
		Iterator<Gebruiker> iterator = gs.getAll().iterator();
		List<Gebruiker> gebruikers = new ArrayList<>();
		while (iterator.hasNext()) {
			gebruikers.add(iterator.next());
		}
		return gebruikers;
	}
}
