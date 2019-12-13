package com.barkie.barkie.view;

import com.barkie.barkie.controller.WedstrijdService;
import com.barkie.barkie.domein.Wedstrijd;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WedstrijdEndpoint {
	@Autowired
    WedstrijdService ws;
	
	@GetMapping("aankomend")
	public List<Wedstrijd> getAankomend() {
		return ws.getAankomend();
	}
	
	@GetMapping("wedstrijden")
	public Iterable<Wedstrijd> getWedstrijd() {
		return ws.getWedstrijden();
	}
	
	@PostMapping("wedstrijd")
	public void makeWedstrijd(@RequestBody Wedstrijd game) {
		ws.addWedstrijd(game);
	}
}
