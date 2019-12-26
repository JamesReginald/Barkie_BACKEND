package com.barkie.barkie.view;

import com.barkie.barkie.domein.Aanvraag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		if (gs.getGebruikerFromNaam(newGebruiker.getUsername()) == null) {
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
	@RequestMapping("gebruiker/{id}")
	public Gebruiker gebruiker(@PathVariable long id){
		return gs.getFromId(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "gebruiker/{id}/saldo")
	public void setSaldo(@PathVariable long id, @RequestBody Aanvraag aanvraag){
		Gebruiker gebruiker = gs.getFromId(id);
		double geldAanvraag = aanvraag.getBedrag();
		if(aanvraag.isGoedgekeurd()){
			gebruiker.setSaldo(geldAanvraag);
			gs.save(gebruiker);
		}

	}
}
