package com.spand0x.springintro.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    private long id;
    private BigDecimal Balance;
    private User user;

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
//        if(BigDecimal.ZERO.compareTo(balance)>0){
//            throw new IllegalArgumentException("Balance cannot be negative");
//        }
        Balance = balance;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
