package com.barkie.barkie.view;

import com.barkie.barkie.controller.WedstrijdService;
import com.barkie.barkie.domein.Wedstrijd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
