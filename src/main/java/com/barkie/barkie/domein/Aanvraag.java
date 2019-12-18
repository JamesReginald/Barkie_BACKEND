package com.barkie.barkie.domein;

import javax.persistence.*;

@Entity
public class Aanvraag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private boolean isGoedgekeurd;

    @Column
    private double bedrag;

    public Long getId() {
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

}
