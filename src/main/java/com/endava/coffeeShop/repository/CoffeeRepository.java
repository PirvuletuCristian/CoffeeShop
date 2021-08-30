package com.endava.coffeeShop.repository;

import com.endava.coffeeShop.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
