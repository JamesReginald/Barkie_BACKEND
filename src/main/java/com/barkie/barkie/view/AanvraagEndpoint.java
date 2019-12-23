package com.barkie.barkie.view;

import com.barkie.barkie.controller.repository.AanvraagRepository;
import com.barkie.barkie.controller.service.AanvraagService;
import com.barkie.barkie.domein.Aanvraag;
import com.barkie.barkie.domein.Gebruiker;
import com.barkie.barkie.domein.Wedstrijd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "aanvraag")
public class AanvraagEndpoint {

    /** AanvraagService object to persist aanvraag objects */
    private final AanvraagService aanvraagService;

    @Autowired
    public AanvraagEndpoint(AanvraagService aanvraagService) {
        this.aanvraagService = aanvraagService;
    }

    /**
     * This endpoint handles the request to obtain a List containing all Aanvraag objects
     * @return List<Aanvraag>
     */
    @GetMapping(value = "/")
    public List<Aanvraag> getAllAanvragen() {
        Iterator<Aanvraag> iterator = aanvraagService.getAll().iterator();
        List<Aanvraag> aanvragen = new ArrayList<>();
        while (iterator.hasNext()) {
            aanvragen.add(iterator.next());
        }
        return aanvragen;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/")
    public void addAanvraag(@RequestBody Aanvraag aanvraag){
        aanvraagService.addAanvraag(aanvraag);
    }

    @RequestMapping("/{id}")
        public Aanvraag getAanvraag(@PathVariable long id){
        return aanvraagService.getFromId( id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public void deleteAanvraag(@PathVariable long id){
        aanvraagService.deleteAanvraag(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateAanvraag(@RequestBody Aanvraag aanvraag, @PathVariable long id){
        if(id==aanvraag.getId())
        aanvraagService.updateAanvraag(aanvraag, id);
    }



}
