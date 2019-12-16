package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long team_id;
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

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public String getNaamTeam() {
        return naamTeam;
    }

    public void setNaamTeam(String naamTeam) {
        this.naamTeam = naamTeam;
    }
}
