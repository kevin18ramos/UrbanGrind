package com.kriscfoster.coffeeshopsim.barista;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kriscfoster.coffeeshopsim.coffee.Coffee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Barista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "barista")
    private Set<Coffee> coffees;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coffee> getCoffees() {
        return this.coffees;
    }

}
