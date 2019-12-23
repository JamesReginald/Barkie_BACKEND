package com.barkie.barkie.view;

import com.barkie.barkie.controller.service.WeddenschapService;
import com.barkie.barkie.domein.Weddenschap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "weddenschap")
public class WeddenschapEndpoint {

    /** WeddenschapService object to persist Weddenschap objects */
    private final WeddenschapService weddenschapService;

    @Autowired
    public WeddenschapEndpoint(WeddenschapService weddenschapService) {
        this.weddenschapService = weddenschapService;
    }

    /**
     * This endpoint handles the request to obtain a List containing all Weddenschap objects
     * @return List<Weddenschap>
     */
    @GetMapping(value = "/")
    public List<Weddenschap> getAllWeddenschappen() {
        Iterator<Weddenschap> iterator = weddenschapService.getAll().iterator();
        List<Weddenschap> weddenschappen = new ArrayList<>();
        while (iterator.hasNext()) {
            weddenschappen.add(iterator.next());
        }
        return weddenschappen;
    }
    @RequestMapping("/{id}")
    public Weddenschap getWeddenschap(@PathVariable Long id){
        Weddenschap weddenschap =weddenschapService.getFromId(id);
        return weddenschap;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addWeddenschap(@RequestBody Weddenschap weddenschap){
        weddenschapService.save(weddenschap);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateWeddenschap(@PathVariable long id, @RequestBody Weddenschap weddenschap){
        weddenschapService.save(weddenschap);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteWeddenschap(@PathVariable long id){ weddenschapService.deleteWeddenschap(id);
    }
}
