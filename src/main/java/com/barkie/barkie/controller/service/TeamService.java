package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.TeamRepository;
import com.barkie.barkie.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService extends DefaultServiceImplementation<Team>{

    /** TeamRepository object to persist Team objects */
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        super(teamRepository);
        this.teamRepository = teamRepository;
    }

}

