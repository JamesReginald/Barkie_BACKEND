package com.barkie.barkie.view;

import com.barkie.barkie.controller.service.RoleService;
import com.barkie.barkie.domein.Aanvraag;
import com.barkie.barkie.domein.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.barkie.barkie.controller.service.GebruikerService;
import com.barkie.barkie.domein.Gebruiker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "gebruiker")
public class GebruikerEndpoint {

	@Autowired
    GebruikerService gs;

	@Autowired
	RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/create")
	public ResponseEntity<Gebruiker> setGebruiker(@RequestBody Gebruiker newGebruiker) {
		if (gs.getGebruikerFromNaam(newGebruiker.getUsername()) == null) {
			final Role role = roleService.findByName("ROLE_USER");
			newGebruiker.setRoles(Stream.of(role).collect(Collectors.toSet()));
			newGebruiker.setPassword(passwordEncoder.encode(newGebruiker.getPassword()));
			return new ResponseEntity<>(gs.save(newGebruiker), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/")
	public List<Gebruiker> getAllGebruikers() {
		Iterator<Gebruiker> iterator = gs.getAll().iterator();
		List<Gebruiker> gebruikers = new ArrayList<>();
		while (iterator.hasNext()) {
			gebruikers.add(iterator.next());
		}
		return gebruikers;
	}

	@GetMapping("/fromLoggedInUser")
	public Gebruiker gebruiker(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return getGebruikerFromSecurityContext(authentication);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/saldo")
	public void setSaldo(@PathVariable long id, @RequestBody Aanvraag aanvraag){
		Gebruiker gebruiker = gs.getFromId(id);
		double geldAanvraag = aanvraag.getBedrag();
		if(aanvraag.isGoedgekeurd()){
			gebruiker.setSaldo(geldAanvraag);
			gs.save(gebruiker);
		}

	}

	private Gebruiker getGebruikerFromSecurityContext(Authentication authentication){
		final String currentPrincipalName = authentication.getName();
		return gs.getGebruikerFromNaam(currentPrincipalName);
	}
}
