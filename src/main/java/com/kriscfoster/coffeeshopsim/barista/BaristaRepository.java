package com.kriscfoster.coffeeshopsim.barista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaristaRepository extends JpaRepository<Barista, Long> {}
