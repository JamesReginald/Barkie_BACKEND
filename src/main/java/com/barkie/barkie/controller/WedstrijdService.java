package com.barkie.barkie.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wr;
    
    public void addWedstrijd(Wedstrijd newGame) {
    	wr.save(newGame);
    }
    
    public List<Wedstrijd> getAankomend() {
    	return wr.findByBeginTijdAfter(LocalDateTime.now());
    }
    
    public Iterable<Wedstrijd> getWedstrijden() {
    	return wr.findAll();
    }
    
}
