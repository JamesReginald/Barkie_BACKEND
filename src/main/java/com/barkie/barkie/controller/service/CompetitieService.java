package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.CompetitieRepository;
import com.barkie.barkie.domein.Competitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetitieService extends DefaultService<Competitie> {

    /** CompetitieRepository object to persist Competitie objects */
    private CompetitieRepository competitieRepository;

    @Autowired
    public CompetitieService(CompetitieRepository competitieRepository) {
        super(competitieRepository);
        this.competitieRepository = competitieRepository;
    }
}

