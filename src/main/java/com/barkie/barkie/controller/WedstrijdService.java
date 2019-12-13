package com.barkie.barkie.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wr;

    public void addWedstrijd(LocalDateTime beginTijd, double kansThuis, double kansUit, int scoreThuis, int scoreUit, String competitie) {
    	Wedstrijd newWed = new Wedstrijd();
    	newWed.setBeginTijd(beginTijd);
    	newWed.setKansThuis(kansThuis);
    	newWed.setKansUit(kansUit);
    	newWed.setScoreThuis(scoreThuis);
    	newWed.setScoreUit(scoreUit);
    	newWed.setCompetitie(competitie);
        wr.save(newWed);
    }
    
    public Iterable<Wedstrijd> getWedstrijden() {
    	return wr.findAll();
    }
    
}
