package com.barkie.barkie.domein;

import javax.persistence.*;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gebruiker_id;

    /** String representation of the username of the user */
    private String gebruikersNaam;

    /** String representation of the role of the user */
    private String rol;

    /** Wallet object that holds the balance of the user and transactions */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Wallet wallet;

    /** String representation of the password of the user */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGebruiker_id() {
        return gebruiker_id;
    }

    public void setGebruiker_id(Long gebruiker_id) {
        this.gebruiker_id = gebruiker_id;
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}
