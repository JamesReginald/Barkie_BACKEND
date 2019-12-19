package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.WeddenschapRepository;
import com.barkie.barkie.domein.Weddenschap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WeddenschapService implements DefaultService<Weddenschap> {

    @Autowired
    private WeddenschapRepository weddenschapRepository;

    @Override
    public Weddenschap getFromId(Long id) {
        Optional<Weddenschap> optionalWeddenschap = weddenschapRepository.findById(id);
        if (optionalWeddenschap.isPresent()) {
            return optionalWeddenschap.get();
        }
        return null;
    }

    @Override
    public Weddenschap save(Weddenschap weddenschap) {
        return weddenschapRepository.save(weddenschap);
    }

    @Override
    public Iterable<Weddenschap> getAll() {
        return weddenschapRepository.findAll();
    }
}
