package com.pizzacustomizer.service.pizza;

import com.pizzacustomizer.model.dto.PizzaDto;

import java.util.List;
import java.util.Optional;

public interface IPizzaService {
    PizzaDto createPizza(PizzaDto pizzaDto);

    PizzaDto updatePizza(PizzaDto pizzaDto);

    List<PizzaDto> findAllPizzas();

    Optional<PizzaDto> findPizzaById(Long id);
}
