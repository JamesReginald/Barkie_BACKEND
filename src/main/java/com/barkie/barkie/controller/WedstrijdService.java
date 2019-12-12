package com.barkie.barkie.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wr;

    public void addWedstrijd(LocalDateTime tijd) {
    	Wedstrijd newWed = new Wedstrijd();
    	newWed.setBeginTijd(tijd);
        wr.save(newWed);
    }
    
    public Iterable<Wedstrijd> getWedstrijden() {
    	return wr.findAll();
    }
    
}
