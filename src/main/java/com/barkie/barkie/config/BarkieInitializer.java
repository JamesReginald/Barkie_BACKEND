package com.barkie.barkie.config;

import com.barkie.barkie.controller.service.*;
import com.barkie.barkie.domein.Aanvraag;
import com.barkie.barkie.domein.Gebruiker;
import com.barkie.barkie.domein.Team;
import com.barkie.barkie.domein.Weddenschap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BarkieInitializer {

    private final GebruikerService gebruikerService;
    private final WedstrijdService wedstrijdService;
    private final WeddenschapService weddenschapService;
    private final TeamService teamService;
    private final AanvraagService aanvraagService;

    @Autowired
    public BarkieInitializer(GebruikerService gebruikerService, WedstrijdService wedstrijdService, WeddenschapService weddenschapService, TeamService teamService, AanvraagService aanvraagService) {
        this.gebruikerService = gebruikerService;
        this.wedstrijdService = wedstrijdService;
        this.weddenschapService = weddenschapService;
        this.teamService = teamService;
        this.aanvraagService = aanvraagService;
    }

    @PostConstruct
    public void init() {
        Gebruiker joshua = createUser("Joshua", "password");
        Gebruiker jim= createUser("Jim", "password");
        Gebruiker joey = createUser("Joey", "password");

        Team barcelona = createTeam("FC Barcelona");
        Team liverpool = createTeam("Liverpool");
        Team ajax = createTeam("Ajax");

        Weddenschap weddenschap1 = createWeddenschap(20.00, joshua, Weddenschap.Bet.GELIJK);
        Weddenschap weddenschap2 = createWeddenschap(23.00, jim, Weddenschap.Bet.THUIS);
        Weddenschap weddenschap3 = createWeddenschap(50, joey, Weddenschap.Bet.UIT);

        Aanvraag aanvraag1 = createAanvraag(10.0, false, joshua);
        Aanvraag aanvraag2 = createAanvraag(100.0, false, jim);
        Aanvraag aanvraag3 = createAanvraag(120.0, false, joey);

    }

    private Aanvraag createAanvraag(double amount, boolean goedGekeurd, Gebruiker gebruiker){
        Aanvraag aanvraag = new Aanvraag();
        aanvraag.setBedrag(amount);
        aanvraag.setGoedgekeurd(goedGekeurd);
        aanvraag.setGebruiker(gebruiker);
        return aanvraagService.save(aanvraag);
    }

    private Gebruiker createUser(String username, String password) {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setGebruikersNaam(username);
        gebruiker.setPassword(password);
        return gebruikerService.save(gebruiker);
    }

    private Weddenschap createWeddenschap(double amount, Gebruiker gebruiker, Weddenschap.Bet bet) {
        Weddenschap weddenschap = new Weddenschap();
        weddenschap.setBedrag(amount);
        weddenschap.setGebruiker(gebruiker);
        weddenschap.setWeddenschap(bet);
        return weddenschapService.save(weddenschap);
    }

    private Team createTeam(String naam) {
        Team team = new Team();
        team.setNaamTeam(naam);
        return teamService.save(team);
    }

}
