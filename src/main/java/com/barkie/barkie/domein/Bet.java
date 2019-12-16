package com.barkie.barkie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bet_id;

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public int getBetResult() {
        return betResult;
    }

    public void setBetResult(int betResult) {
        this.betResult = betResult;
    }

    private double bedrag;

    private int betResult;// 1 = winst home 2 = winst visitors 3 = gelijk
}
