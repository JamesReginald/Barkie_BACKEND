package com.barkie.barkie.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Joshua
 */
@Entity
public class Aanvraag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** this boolean represents whether the request by a user is granted or not */
    @Column
    private boolean isGoedgekeurd;

    /** This double represents the amount of money the user wants to add to their wallet */
    @Column
    private double bedrag;

    /** Gebruiker object that represents a user */
    @ManyToOne
    @JoinColumn(name = "gebruiker_id", nullable = false)
    private Gebruiker gebruiker;


    public long getId() {
        return id;
    }

    public boolean isGoedgekeurd() {
        return isGoedgekeurd;
    }

    public void setGoedgekeurd(boolean goedgekeurd) {
        isGoedgekeurd = goedgekeurd;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    @Override
    public String toString() {
        return "Aanvraag{" +
                "id=" + id +
                ", isGoedgekeurd=" + isGoedgekeurd +
                ", bedrag=" + bedrag +
                '}';
    }
}
