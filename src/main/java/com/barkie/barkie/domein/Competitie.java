package com.barkie.barkie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competitie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String naamCompetie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaamCompetie() {
        return naamCompetie;
    }

    public void setNaamCompetie(String naamCompetie) {
        this.naamCompetie = naamCompetie;
    }
}
