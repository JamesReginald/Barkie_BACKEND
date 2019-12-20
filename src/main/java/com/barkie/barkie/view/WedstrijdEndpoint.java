package com.barkie.barkie.view;

import com.barkie.barkie.controller.service.WedstrijdService;
import com.barkie.barkie.domein.Wedstrijd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WedstrijdEndpoint {
	@Autowired
    WedstrijdService ws;
	
	@GetMapping("aankomend")
	public ResponseEntity<List<Wedstrijd>> getAankomend() {
		return ws.getAankomend();
	}
	
	@GetMapping("wedstrijden")
	public ResponseEntity<List<Wedstrijd>> getWedstrijd() {
		return new ResponseEntity(ws.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("wedstrijd")
	public ResponseEntity<Wedstrijd> makeWedstrijd(@RequestBody Wedstrijd game) {
		return new ResponseEntity<>(ws.save(game), HttpStatus.OK);
	}
}
