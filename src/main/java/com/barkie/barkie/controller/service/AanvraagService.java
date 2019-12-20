package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.AanvraagRepository;
import com.barkie.barkie.domein.Aanvraag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AanvraagService extends DefaultServiceImplementation<Aanvraag> {

    /** AanvraagRepository object to persist Aanvraag objects */
    private AanvraagRepository aanvraagRepository;

    @Autowired
    public AanvraagService(AanvraagRepository aanvraagRepository) {
        super(aanvraagRepository);
        this.aanvraagRepository = aanvraagRepository;
    }

}
