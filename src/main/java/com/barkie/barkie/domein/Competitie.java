package com.barkie.barkie.domein;

import javax.persistence.*;

@Entity
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comp_id;

    /** String representation of the name of the competition */
    private String naam;

    public long getComp_id() {
        return comp_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Competitie{" +
                "comp_id=" + comp_id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
