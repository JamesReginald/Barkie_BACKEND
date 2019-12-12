package com.barkie.barkie.controller;

import com.barkie.barkie.domein.Competitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompetitieService {
    @Autowired
    CompetitieRepository cr;

    public void ffproberen() {

        cr.save(new Competitie());
    }
}

