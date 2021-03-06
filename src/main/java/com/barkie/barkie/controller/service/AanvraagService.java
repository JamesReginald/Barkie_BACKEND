package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.AanvraagRepository;
import com.barkie.barkie.domein.Aanvraag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AanvraagService extends DefaultService<Aanvraag> {

    /** AanvraagRepository object to persist Aanvraag objects */
    private AanvraagRepository aanvraagRepository;

    @Autowired
    public AanvraagService(AanvraagRepository aanvraagRepository) {
        super(aanvraagRepository);
        this.aanvraagRepository = aanvraagRepository;
    }

    public void deleteAanvraag(long id) {
        aanvraagRepository.deleteById(id);
    }

    /**
     * This method returns a List of Aanvraag objects based in the user id
     * @param id
     * @return
     */
    public List<Aanvraag> getAllAanvragenFromUserId(Long id){
        return aanvraagRepository.getAllByGebruiker_Id(id);
    }
}
