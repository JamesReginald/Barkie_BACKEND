package com.barkie.barkie.controller;

import com.barkie.barkie.domein.Gebruiker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {
}
