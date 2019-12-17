package com.barkie.barkie.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wr;

    public ResponseEntity<Wedstrijd> addWedstrijd(Wedstrijd newGame) {
    	return new ResponseEntity<>(wr.save(newGame), HttpStatus.OK);
    }
    
    public ResponseEntity<List<Wedstrijd>> getAankomend() {
    	List<Wedstrijd> aankomend = wr.findByBeginTijdAfter(LocalDateTime.now());
    	if (aankomend.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<>(aankomend, HttpStatus.OK);
    }
    
    public ResponseEntity<Iterable<Wedstrijd>> getWedstrijden() {
    	return new ResponseEntity<>(wr.findAll(), HttpStatus.OK);
    }
    
}
