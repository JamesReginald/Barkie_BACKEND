package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.TeamRepository;
import com.barkie.barkie.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService extends DefaultService<Team>{

    /** TeamRepository object to persist Team objects */
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        super(teamRepository);
        this.teamRepository = teamRepository;
    }


}

