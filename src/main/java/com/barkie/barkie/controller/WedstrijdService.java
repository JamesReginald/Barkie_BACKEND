package com.barkie.barkie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wr;

    public void ffproberen() {

        wr.save(new Wedstrijd());
    }
    
    public Iterable<Wedstrijd> getWedstrijden() {
    	return wr.findAll();
    }
    
}
