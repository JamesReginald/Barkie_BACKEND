package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.List;

@Entity
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comp_id;

    private String naamCompetie;

    public long getComp_id() {
        return comp_id;
    }

    public String getNaamCompetie() {
        return naamCompetie;
    }

    public void setNaamCompetie(String naamCompetie) {
        this.naamCompetie = naamCompetie;
    }
}
