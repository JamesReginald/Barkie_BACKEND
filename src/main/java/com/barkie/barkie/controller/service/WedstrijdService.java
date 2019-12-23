package com.barkie.barkie.controller.service;


import java.time.LocalDateTime;
import java.util.List;

import com.barkie.barkie.controller.repository.WedstrijdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.barkie.barkie.domein.Wedstrijd;


@Service
public class WedstrijdService extends DefaultService<Wedstrijd>{

    /** WedstrijdRepository object to persist Wedstrijd objects */
    private WedstrijdRepository wedstrijdRepository;

    @Autowired
    public WedstrijdService(WedstrijdRepository wedstrijdRepository) {
        super(wedstrijdRepository);
        this.wedstrijdRepository = wedstrijdRepository;
    }

    public ResponseEntity<List<Wedstrijd>> getAankomend() {
    	List<Wedstrijd> aankomend = wedstrijdRepository.findByBeginTijdAfter(LocalDateTime.now());
    	if (aankomend.isEmpty()) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<>(aankomend, HttpStatus.OK);
    }

}
