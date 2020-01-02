package com.barkie.barkie.view;

import com.barkie.barkie.controller.service.AanvraagService;
import com.barkie.barkie.controller.service.GebruikerService;
import com.barkie.barkie.domein.Aanvraag;
import com.barkie.barkie.domein.Gebruiker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "aanvraag")
public class AanvraagEndpoint {

    /** AanvraagService object to persist aanvraag objects */
    private final AanvraagService aanvraagService;

    private final GebruikerService gebruikerService;

    @Autowired
    public AanvraagEndpoint(AanvraagService aanvraagService, GebruikerService gebruikerService) {
        this.aanvraagService = aanvraagService;
        this.gebruikerService = gebruikerService;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Gebruiker gebruikerFromDb = gebruikerService.getGebruikerFromNaam(currentPrincipalName);
        aanvraag.setGebruiker(gebruikerFromDb);
        aanvraag.setDateAdded(LocalDate.now());

        aanvraagService.save(aanvraag);
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
            aanvraagService.save(aanvraag);
    }

    @GetMapping(value = "/fromLoggedInUser")
    public List<Aanvraag> getAanvragenFromUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Gebruiker gebruikerFromDb = getGebruikerFromSecurityContext(authentication);

        return aanvraagService.getAllAanvragenFromUserId(gebruikerFromDb.getId());
    }

    private Gebruiker getGebruikerFromSecurityContext(Authentication authentication){
        final String currentPrincipalName = authentication.getName();
        return gebruikerService.getGebruikerFromNaam(currentPrincipalName);
    }



}
