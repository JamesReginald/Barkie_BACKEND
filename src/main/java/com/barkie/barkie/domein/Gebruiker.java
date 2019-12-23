package com.barkie.barkie.domein;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gebruiker_id;

    /** String representation of the username of the user */
    private String gebruikersNaam;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }

    private double saldo;

    /** String representation of the password of the user */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /** String representation of the role of the user */
    private String rol;

    /** List containing all Aanvraag objects of the user */
    @OneToMany(mappedBy = "gebruiker", cascade = CascadeType.PERSIST)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Aanvraag> aanvragen;

    /** List containing all Weddenschap objects of the user */
    @OneToMany(mappedBy = "gebruiker", cascade = CascadeType.PERSIST)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Weddenschap> weddenschappen;

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

    public List<Aanvraag> getAanvragen() {
        return aanvragen;
    }

    public void setAanvragen(List<Aanvraag> aanvragen) {
        this.aanvragen = aanvragen;
    }

    public List<Weddenschap> getWeddenschappen() {
        return weddenschappen;
    }

    public void setWeddenschappen(List<Weddenschap> weddenschappen) {
        this.weddenschappen = weddenschappen;
    }
}
