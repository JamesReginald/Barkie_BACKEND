package com.barkie.barkie.view;

import com.barkie.barkie.controller.service.AanvraagService;
import com.barkie.barkie.domein.Aanvraag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
