package com.kriscfoster.coffeeshopsim.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository
        extends JpaRepository<Coffee, Long> {
    Optional<Coffee> getCoffeeById(Long coffeeId);

    public default void deleteCoffee(Long coffeeId){

        deleteById(coffeeId);
    }
}
