package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long team_id;

    /** String representation of the name of the team */
    private String naamTeam;

    @ManyToMany
    private List<Competitie> competities;

    public long getTeam_id() {
        return team_id;
    }

    public List<Competitie> getCompetities() {
        return competities;
    }

    public void setCompetities(List<Competitie> competities) {
        this.competities = competities;
    }

    public String getNaamTeam() {
        return naamTeam;
    }

    public void setNaamTeam(String naamTeam) {
        this.naamTeam = naamTeam;
    }
}
