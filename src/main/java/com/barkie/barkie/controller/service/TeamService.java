package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.TeamRepository;
import com.barkie.barkie.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService implements DefaultService<Team>{

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Team getFromId(Long id) {
        Optional<Team> optionalWallet = teamRepository.findById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        return null;
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}

