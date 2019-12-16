package com.barkie.barkie.domein;

import javax.persistence.*;
import java.util.List;

@Entity
public class Competitie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comp_id;

    private String naamCompetie;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "team_comp",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comp_id", referencedColumnName = "id"))
    private List<Team> teams;

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
