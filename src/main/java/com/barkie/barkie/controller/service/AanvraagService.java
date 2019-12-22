package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.AanvraagRepository;
import com.barkie.barkie.controller.repository.GebruikerRepository;
import com.barkie.barkie.domein.Aanvraag;
import com.barkie.barkie.domein.Gebruiker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AanvraagService extends DefaultServiceImplementation<Aanvraag> {

    /** AanvraagRepository object to persist Aanvraag objects */
    private AanvraagRepository aanvraagRepository;



    @Autowired
    public AanvraagService(AanvraagRepository aanvraagRepository) {
        super(aanvraagRepository);
        this.aanvraagRepository = aanvraagRepository;
    }

    public void addAanvraag(Aanvraag aanvraag)
    {
        aanvraagRepository.save(aanvraag);
    }


    public Aanvraag getAanvraag(long id) {
        Optional<Aanvraag> optionalAanvraag = aanvraagRepository.findById(id);
        if (optionalAanvraag.isPresent()){
            return optionalAanvraag.get();
        }
        return null;
    }

    public void deleteAanvraag(long id) {
        aanvraagRepository.deleteById(id);
    }

    public void updateAanvraag(Aanvraag aanvraag, long id) {
       aanvraagRepository.save(aanvraag);

    }
}
