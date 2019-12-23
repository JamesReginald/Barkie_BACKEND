package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comp_id;

    /** String representation of the name of the competition */
    private String naam;

    /** List containing Team objects */
    @ManyToMany(mappedBy = "competities")
    private List<Team> teams;

    public long getComp_id() {
        return comp_id;
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
                "comp_id=" + comp_id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
