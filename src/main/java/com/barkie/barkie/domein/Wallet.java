package com.barkie.barkie.domein;

import javax.persistence.*;

/**
 * Created by Joshua
 */
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** double value that represents the balance of the user */
    @Column
    private double saldo;

    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", saldo=" + saldo +
                '}';
    }
}
