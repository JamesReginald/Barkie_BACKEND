package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.AanvraagRepository;
import com.barkie.barkie.domein.Aanvraag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AanvraagService implements DefaultService<Aanvraag> {

    @Autowired
    private AanvraagRepository aanvraagRepository;

    @Override
    public Aanvraag getFromId(Long id) {
        Optional<Aanvraag> optionalAanvraag = aanvraagRepository.findById(id);
        if (optionalAanvraag.isPresent()) {
            return optionalAanvraag.get();
        }
        return null;
    }

    @Override
    public Aanvraag save(Aanvraag aanvraag) {
        return aanvraagRepository.save(aanvraag);
    }

    @Override
    public Iterable<Aanvraag> getAll() {
        return aanvraagRepository.findAll();
    }
}
