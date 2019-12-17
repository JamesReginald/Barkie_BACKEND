package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Gebruiker;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {
	
	List<Gebruiker> findByGebruikersNaamAndPassword(String gebruikersNaam, String password);
	
	List<Gebruiker> findByGebruikersNaam(String gebruikersNaam);
}
