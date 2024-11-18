package com.pizzacustomizer.broker.storage.pizza;

import com.pizzacustomizer.model.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface IPizzaStoragebroker {
    Pizza create(Pizza pizza);
    Pizza update(Pizza pizza);
    List<Pizza> findAll(Class<Pizza> type);
    Optional<Pizza> findById(Class<Pizza> type, Long id);
}
