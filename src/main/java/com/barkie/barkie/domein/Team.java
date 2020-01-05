package com.barkie.barkie.domein;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** String representation of the name of the team */
    private String naam;

    /** List containing Competitie objects */
    @ManyToMany
    @JoinTable(name="TEAM_COMPETITIE",
            joinColumns = @JoinColumn(name="TEAM_ID"),
            inverseJoinColumns = @JoinColumn(name="COMPETITIE_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Competitie> competities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Competitie> getCompetities() {
        return competities;
    }

    public void setCompetities(List<Competitie> competities) {
        this.competities = competities;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
