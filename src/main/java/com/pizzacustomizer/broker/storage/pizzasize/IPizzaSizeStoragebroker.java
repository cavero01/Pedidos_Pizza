package com.pizzacustomizer.broker.storage.pizzasize;

import com.pizzacustomizer.model.entity.PizzaSize;

import java.util.List;
import java.util.Optional;

public interface IPizzaSizeStoragebroker {
    PizzaSize create(PizzaSize pizzaSize);
    PizzaSize update(PizzaSize pizzaSize);
    List<PizzaSize> findAll(Class<PizzaSize> type);
    Optional<PizzaSize> findById(Class<PizzaSize> type, Long id);
}
