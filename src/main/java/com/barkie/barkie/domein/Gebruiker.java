package com.barkie.barkie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String gebruikersNaam;
    private String rol;
    private double wallet;

    public Gebruiker( long id, String gebruikersNaam, String rol, double wallet) {
        this.id = id;
        this.gebruikersNaam = gebruikersNaam;
        this.rol = rol;
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

}
