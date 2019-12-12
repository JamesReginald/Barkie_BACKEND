package com.barkie.barkie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String naamTeam;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaamTeam() {
        return naamTeam;
    }

    public void setNaamTeam(String naamTeam) {
        this.naamTeam = naamTeam;
    }
}
