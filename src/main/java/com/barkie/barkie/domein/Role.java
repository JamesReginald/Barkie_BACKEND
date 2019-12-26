package com.barkie.barkie.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Role() { }

    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Gebruiker> gebruikers;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruiker(Set<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }
}
