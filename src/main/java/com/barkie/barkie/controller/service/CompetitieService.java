package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.CompetitieRepository;
import com.barkie.barkie.domein.Competitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompetitieService implements DefaultService<Competitie> {
    @Autowired
    CompetitieRepository competitieRepository;

    @Override
    public Competitie getFromId(Long id) {
        Optional<Competitie> optionalWallet = competitieRepository.findById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        return null;
    }

    @Override
    public Competitie save(Competitie competitie) {
        return competitieRepository.save(competitie);
    }
}

