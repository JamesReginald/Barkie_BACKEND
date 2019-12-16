package com.barkie.barkie.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barkie.barkie.controller.GebruikerService;

@RestController
public class GebruikerEndpoint {
	@Autowired
    GebruikerService gs;
	
	@GetMapping("gebruiker/{naam}")
	public void getGebruiker(@PathVariable String naam) {
		System.out.println("in getGebruiker met:" + naam);
	}
}
