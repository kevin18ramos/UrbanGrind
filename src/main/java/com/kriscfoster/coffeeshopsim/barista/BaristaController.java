package com.kriscfoster.coffeeshopsim.barista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baristas")
public class BaristaController {

    @Autowired
    BaristaRepository baristaRepository;

    @GetMapping
    List<Barista> getBaristas() {
        return baristaRepository.findAll();
    }

    @PostMapping
    Barista createBarista(@RequestBody Barista barista) {
        return baristaRepository.save(barista);
    }
}
