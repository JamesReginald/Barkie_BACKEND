package com.barkie.barkie.config;

import com.barkie.barkie.controller.service.*;
import com.barkie.barkie.domein.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BarkieInitializer {

    private final GebruikerService gebruikerService;
    private final WedstrijdService wedstrijdService;
    private final WeddenschapService weddenschapService;
    private final TeamService teamService;
    private final CompetitieService competitieService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AanvraagService aanvraagService;

    @Autowired
    public BarkieInitializer(GebruikerService gebruikerService, WedstrijdService wedstrijdService, WeddenschapService weddenschapService, TeamService teamService, CompetitieService competitieService, RoleService roleService, PasswordEncoder passwordEncoder, AanvraagService aanvraagService) {
        this.gebruikerService = gebruikerService;
        this.wedstrijdService = wedstrijdService;
        this.weddenschapService = weddenschapService;
        this.teamService = teamService;
        this.competitieService = competitieService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.aanvraagService = aanvraagService;
    }

    @PostConstruct
    public void init() {

        Role adminRole = createRoleIfNotFound("ROLE_ADMIN");
        Role userRole = createRoleIfNotFound("ROLE_USER");

        Gebruiker admin = createUserIfNotFound("admin", Stream.of(userRole, adminRole).collect(Collectors.toSet()));
        Gebruiker user = createUserIfNotFound("user", Stream.of(userRole).collect(Collectors.toSet()));

        Team barcelona = createTeam("FC Barcelona");
        Team liverpool = createTeam("Liverpool");
        Team ajax = createTeam("Ajax");
        Team realMadrid = createTeam("Real Madrid");

        List<Team> teams = new ArrayList<>();
        teams.add(barcelona);
        teams.add(liverpool);
        teams.add(ajax);
        teams.add(realMadrid);

        Competitie championsLeague = createCompetitie("Champions League", teams);

        Wedstrijd wedstrijd1 = createWedstrijd(LocalDateTime.now(), 1.78, 5.7, 4.87, barcelona, liverpool);
        Wedstrijd wedstrijd2 = createWedstrijd(LocalDateTime.now(), 4.25, 7.3, 1.24, ajax, realMadrid);
        Wedstrijd wedstrijd3 = createWedstrijd(LocalDateTime.now(), 6.32, 5.3, 1.1, liverpool, ajax);

        Weddenschap weddenschap1 = createWeddenschap(20.00, user, Weddenschap.Bet.GELIJK, wedstrijd1);
        Weddenschap weddenschap2 = createWeddenschap(23.00, user, Weddenschap.Bet.THUIS, wedstrijd2);
        Weddenschap weddenschap3 = createWeddenschap(50, admin, Weddenschap.Bet.UIT, wedstrijd1);

        Aanvraag aanvraag1 = createAanvraag(false, 43.0, user);
        Aanvraag aanvraag2 = createAanvraag(true, 20.0, user);
        Aanvraag aanvraag3 = createAanvraag(true, 56.0, user);
        Aanvraag aanvraag4 = createAanvraag(false, 413.0, user);
    }

    /**
     * Creates a role when specified role is not found in the database
     * @param username String representation of the username
     * @return User
     */
    private Gebruiker createUserIfNotFound(String username, Set<Role> roles) {
        Gebruiker user = gebruikerService.getGebruikerFromNaam(username);

        if (user == null) {
            user = new Gebruiker();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode("password"));
            user.setRoles(roles);
            gebruikerService.save(user);
        }

        return user;
    }

    private Weddenschap createWeddenschap(double amount, Gebruiker gebruiker, Weddenschap.Bet bet, Wedstrijd wedstrijd) {
        Weddenschap weddenschap = new Weddenschap();
        weddenschap.setBedrag(amount);
        weddenschap.setGebruiker(gebruiker);
        weddenschap.setWeddenschap(bet);
        weddenschap.setWedstrijd(wedstrijd);
        return weddenschapService.save(weddenschap);
    }

    private Team createTeam(String naam) {
        Team team = new Team();
        team.setNaam(naam);
        return teamService.save(team);
    }

    private Competitie createCompetitie(String naam, List<Team> teams) {
        Competitie competitie = new Competitie();
        competitie.setNaam(naam);
        Competitie saved = competitieService.save(competitie);

        for (Team team : teams) {
            team.setCompetities(Arrays.asList(saved));
            teamService.save(team);
        }
        return saved;
    }

    private Aanvraag createAanvraag(boolean isGoedgekeurd, double bedrag, Gebruiker gebruiker) {
        Aanvraag aanvraag = new Aanvraag();
        aanvraag.setGoedgekeurd(isGoedgekeurd);
        aanvraag.setBedrag(bedrag);
        aanvraag.setGebruiker(gebruiker);
        aanvraag.setDateAdded(LocalDate.now());

        return aanvraagService.save(aanvraag);
    }


    private Wedstrijd createWedstrijd(LocalDateTime speelDatumTijd, double kansThuis, double kansGelijk,
                                      double kansUit, Team thuisTeam, Team uitTeam){
        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setBeginTijd(speelDatumTijd);
        wedstrijd.setKansThuis(kansThuis);
        wedstrijd.setKansGelijk(kansGelijk);
        wedstrijd.setKansUit(kansUit);
        wedstrijd.setThuisTeam(thuisTeam);
        wedstrijd.setUitTeam(uitTeam);

        return wedstrijdService.save(wedstrijd);
    }

    /**
     * Creates a role when specified role is not found in the database
     * @param roleName String representation of the role name
     * @return Role
     */
    private Role createRoleIfNotFound(String roleName) {
        Role role = roleService.findByName(roleName);

        if (role == null) {
            role = new Role(roleName);
            roleService.save(role);
        }

        return role;
    }

}
