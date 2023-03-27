package com.kriscfoster.coffeeshopsim;
import com.kriscfoster.coffeeshopsim.barista.Barista;
import com.kriscfoster.coffeeshopsim.barista.BaristaRepository;
import com.kriscfoster.coffeeshopsim.coffee.Coffee;
import com.kriscfoster.coffeeshopsim.coffee.CoffeeRepository;
import com.kriscfoster.coffeeshopsim.customer.Customer;
import com.kriscfoster.coffeeshopsim.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AllController {
    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BaristaRepository baristaRepository;

    @GetMapping(path = "/")
    public String preHomePage() { return "index";}

    @GetMapping("/order")
    public ModelAndView getAllOrders() {
        List<Coffee> list = coffeeRepository.findAll();
        return new ModelAndView("CustomerOrders", "coffees", list);
    }
    @GetMapping(path = "/barista/all")
    public ModelAndView getAllBarista(){
        List<Barista> list = baristaRepository.findAll();
        return new ModelAndView("barista", "baristas", list);
    }
    @GetMapping(path = "/customer/all")
    public ModelAndView getAllCustomer(){
        List<Customer> list = customerRepository.findAll();
        return new ModelAndView("customer", "customers", list);
    }

    @GetMapping(path = "/coffee/all")
    public ModelAndView getAllCoffee(){
        List<Coffee> list = coffeeRepository.findAll();
        return new ModelAndView("coffee", "coffees", list);
    }
}
