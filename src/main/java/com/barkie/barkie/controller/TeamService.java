package com.barkie.barkie.controller;


import com.barkie.barkie.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TeamService {
    @Autowired
    TeamRepository tr;

    public void ffproberen() {

        tr.save(new Team());
    }
}

