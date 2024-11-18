package com.pizzacustomizer.service.pizzasize;

import com.pizzacustomizer.model.dto.PizzaSizeDto;

import java.util.List;
import java.util.Optional;

public interface IPizzaSizeService {
    PizzaSizeDto createPizzaSize(PizzaSizeDto pizzaSizeDto);

    PizzaSizeDto updatePizzaSize(PizzaSizeDto pizzaSizeDto);

    List<PizzaSizeDto> findAllPizzaSizes();

    Optional<PizzaSizeDto> findPizzaSizeById(Long id);
}
