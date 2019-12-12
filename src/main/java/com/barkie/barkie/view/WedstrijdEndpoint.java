package com.barkie.barkie.view;

import com.barkie.barkie.controller.WedstrijdService;
import com.barkie.barkie.domein.Wedstrijd;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WedstrijdEndpoint {
	@Autowired
    WedstrijdService ws;
	
	@GetMapping("wedstrijden")
	public Iterable<Wedstrijd> getWedstrijd() {
		return ws.getWedstrijden();
	}
	
	@PostMapping("wedstrijd/{jaar}/{maand}/{dag}")
	public void makeWedstrijd(@PathVariable int jaar, @PathVariable int maand, @PathVariable int dag) {
		LocalDateTime begintijd = LocalDateTime.of(jaar, maand, dag, 0, 0);
		ws.addWedstrijd(begintijd);
	}
	
}
