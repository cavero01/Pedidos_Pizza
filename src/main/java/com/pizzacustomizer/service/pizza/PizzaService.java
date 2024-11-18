package com.pizzacustomizer.service.pizza;

import com.pizzacustomizer.broker.storage.pizza.IPizzaStoragebroker;
import com.pizzacustomizer.model.dto.PizzaDto;
import com.pizzacustomizer.model.entity.Pizza;
import com.pizzacustomizer.util.PizzaMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService implements IPizzaService {

    private final IPizzaStoragebroker pizzaStorageBroker;

    public PizzaService(IPizzaStoragebroker pizzaStorageBroker) {
        this.pizzaStorageBroker = pizzaStorageBroker;
    }

    @Override
    @Transactional
    public PizzaDto createPizza(PizzaDto pizzaDto) {
        Pizza pizza = PizzaMapper.toEntity(pizzaDto);
        PizzaDto createdPizza = PizzaMapper.toDto(pizzaStorageBroker.create(pizza));
        return createdPizza;
    }

    @Override
    @Transactional
    public PizzaDto updatePizza(PizzaDto pizzaDto) {
        Pizza pizza = PizzaMapper.toEntity(pizzaDto);
        PizzaDto updatedPizza = PizzaMapper.toDto(pizzaStorageBroker.update(pizza));
        return updatedPizza;
    }

    @Override
    public List<PizzaDto> findAllPizzas() {
        return pizzaStorageBroker.findAll(Pizza.class).stream()
                .map(PizzaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PizzaDto> findPizzaById(Long id) {
        return pizzaStorageBroker.findById(Pizza.class, id)
                .map(PizzaMapper::toDto);
    }
}
