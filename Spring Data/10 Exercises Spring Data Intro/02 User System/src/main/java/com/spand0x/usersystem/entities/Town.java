package com.spand0x.usersystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Town {
    private long id;
    private String name;
    private String country;
    private Set<User> born;
    private Set<User> live;

    public Town() {
        this.born = new HashSet<>();
        this.live = new HashSet<>();
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

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown",targetEntity = User.class
        ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public Set<User> getBorn() {
        return born;
    }

    public void setBorn(Set<User> born) {
        this.born = born;
    }


    @OneToMany(mappedBy = "currentlyLiving",targetEntity = User.class
            ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public Set<User> getLive() {
        return live;
    }

    public void setLive(Set<User> live) {
        this.live = live;
    }
}
