package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.CompetitieRepository;
import com.barkie.barkie.domein.Competitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompetitieService implements DefaultService<Competitie> {

    @Autowired
    private CompetitieRepository competitieRepository;

    @Override
    public Competitie getFromId(Long id) {
        Optional<Competitie> optionalCompetitie = competitieRepository.findById(id);
        if (optionalCompetitie.isPresent()) {
            return optionalCompetitie.get();
        }
        return null;
    }

    @Override
    public Competitie save(Competitie competitie) {
        return competitieRepository.save(competitie);
    }

    @Override
    public Iterable<Competitie> getAll() {
        return competitieRepository.findAll();
    }
}

