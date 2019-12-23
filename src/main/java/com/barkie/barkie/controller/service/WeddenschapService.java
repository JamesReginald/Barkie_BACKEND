package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.WeddenschapRepository;
import com.barkie.barkie.domein.Weddenschap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddenschapService extends DefaultService<Weddenschap> {

    /** WeddenschapRepository object to persist Weddenschap objects */
    private WeddenschapRepository weddenschapRepository;

    @Autowired
    public WeddenschapService(WeddenschapRepository weddenschapRepository) {
        super(weddenschapRepository);
        this.weddenschapRepository = weddenschapRepository;
    }

    public void deleteWeddenschap(long id) {
        weddenschapRepository.deleteById(id);
    }
}
