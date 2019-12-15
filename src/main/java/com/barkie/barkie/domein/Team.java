package com.barkie.barkie.domein;

import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long team_id;
    private String naamTeam;

    @ManyToOne
    @JoinColumn(name = "wedstrijd_id")
    private Wedstrijd wedstrijd;

    public long getTeam_id() {
        return team_id;
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
