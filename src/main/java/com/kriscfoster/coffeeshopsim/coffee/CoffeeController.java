package com.kriscfoster.coffeeshopsim.coffee;

import com.kriscfoster.coffeeshopsim.customer.Customer;
import com.kriscfoster.coffeeshopsim.customer.CustomerRepository;
import com.kriscfoster.coffeeshopsim.barista.Barista;
import com.kriscfoster.coffeeshopsim.barista.BaristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BaristaRepository baristaRepository;


    @GetMapping
    List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping(path = "{coffeeId}")
    public Optional<Coffee> getCoffeeById(@PathVariable("coffeeId")Long coffeeId){
        return coffeeRepository.getCoffeeById(coffeeId);
    };

    @PostMapping
    Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }
    @DeleteMapping(path = "{coffeeId}")
    public void deleteCoffee(@PathVariable("coffeeId")Long coffeeId){
        coffeeRepository.deleteCoffee(coffeeId);
    }

    @PutMapping("/{coffeeId}/customers/{customerId}")
    Customer addCustomerToCoffee(
            @PathVariable Long coffeeId,
            @PathVariable Long customerId
    ) {
        Coffee coffee = coffeeRepository.findById(coffeeId).get();

        Customer customer = customerRepository.findById(customerId).get();
        coffee.enrolledCustomers.add(customer);
        return customerRepository.save(customer);
    }

    @PutMapping("/{coffeeId}/barista/{baristaId}")
    Coffee assignBaristaToCoffee(
            @PathVariable Long coffeeId,
            @PathVariable Long baristaId
    ) {
        Coffee coffee = coffeeRepository.findById(coffeeId).get();
        Barista barista = baristaRepository.findById(baristaId).get();
        coffee.setBarista(barista);
        return coffeeRepository.save(coffee);
    }
}

