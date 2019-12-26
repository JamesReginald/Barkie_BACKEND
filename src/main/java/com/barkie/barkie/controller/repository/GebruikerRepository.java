package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Gebruiker;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {
	
	List<Gebruiker> findByUsernameAndPassword(String gebruikersNaam, String password);

	Optional<Gebruiker> findByUsername(String gebruikersNaam);
}
