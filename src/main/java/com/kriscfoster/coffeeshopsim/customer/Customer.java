package com.kriscfoster.coffeeshopsim.customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kriscfoster.coffeeshopsim.coffee.Coffee;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCustomers")
    private Set<Coffee> coffees = new HashSet<>();

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
        return coffees;
    }

}
