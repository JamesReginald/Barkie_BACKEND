package com.barkie.barkie.domein;

import javax.persistence.*;

@Entity
public class Weddenschap {

    /** Enum that represents the users bet on a game, this can only be of 3 options: THUIS, UIT & GELIJK */
    public enum Bet {
        THUIS, // winst home
        UIT, //winst visitors
        GELIJK //gelijk
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** double that represents the amount of money the user wants to bet on a game */
    @Column
    private double bedrag;

    /** enum that indicates the users bet on a game */
    private Bet weddenschap;

    public long getId() {
        return id;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public Bet getWeddenschap() {
        return weddenschap;
    }

    public void setWeddenschap(Bet weddenschap) {
        this.weddenschap = weddenschap;
    }
}
