package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** String representation of the name of the competition */
    private String naam;

    /** List containing Team objects */
    @ManyToMany(mappedBy = "competities")
    private List<Team> teams;

    @OneToMany(mappedBy = "competitie", cascade = CascadeType.ALL)
    private List<Wedstrijd> wedstrijden;

    public long getId() {
        return id;
    }

    public List<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    public void setWedstrijden(List<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        teams.forEach(t -> t.setCompetities(Arrays.asList(this)));
    }

    @Override
    public String toString() {
        return "Competitie{" +
                ", naam='" + naam + '\'' +
                '}';
    }
}
