package com.kriscfoster.coffeeshopsim.coffee;

import com.kriscfoster.coffeeshopsim.barista.Barista;
import com.kriscfoster.coffeeshopsim.customer.Customer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "customer_order",
            joinColumns = @JoinColumn(name = "coffee_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    Set<Customer> enrolledCustomers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barista_id", referencedColumnName = "id")
    private Barista barista;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getEnrolledCustomers() {
        return enrolledCustomers;
    }

    public Barista getBarista() {
        return barista;
    }

    public void setBarista(Barista barista) {

        this.barista = barista;
    }

}
