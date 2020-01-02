package com.barkie.barkie.domein;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** String representation of the username of the user */
    private String username;

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

    /** List containing Role objects */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="GEBRUIKER_ROLES",
            joinColumns = @JoinColumn(name="GEBRUIKER_ID"),
            inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Role> roles;

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

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
