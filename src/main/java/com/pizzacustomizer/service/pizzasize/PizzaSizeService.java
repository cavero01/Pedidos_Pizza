package com.pizzacustomizer.service.pizzasize;

import com.pizzacustomizer.broker.storage.pizzasize.IPizzaSizeStoragebroker;
import com.pizzacustomizer.model.dto.PizzaSizeDto;
import com.pizzacustomizer.model.entity.PizzaSize;
import com.pizzacustomizer.util.PizzaSizeMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaSizeService implements IPizzaSizeService {

    private final IPizzaSizeStoragebroker pizzaSizeStorageBroker;

    public PizzaSizeService(IPizzaSizeStoragebroker pizzaSizeStorageBroker) {
        this.pizzaSizeStorageBroker = pizzaSizeStorageBroker;
    }

    @Override
    @Transactional
    public PizzaSizeDto createPizzaSize(PizzaSizeDto pizzaSizeDto) {
        PizzaSize pizzaSize = PizzaSizeMapper.toEntity(pizzaSizeDto);
        PizzaSizeDto createdPizzaSize = PizzaSizeMapper.toDto(pizzaSizeStorageBroker.create(pizzaSize));
        return createdPizzaSize;
    }

    @Override
    @Transactional
    public PizzaSizeDto updatePizzaSize(PizzaSizeDto pizzaSizeDto) {
        PizzaSize pizzaSize = PizzaSizeMapper.toEntity(pizzaSizeDto);
        PizzaSizeDto updatedPizzaSize = PizzaSizeMapper.toDto(pizzaSizeStorageBroker.update(pizzaSize));
        return updatedPizzaSize;
    }

    @Override
    public List<PizzaSizeDto> findAllPizzaSizes() {
        return pizzaSizeStorageBroker.findAll(PizzaSize.class).stream()
                .map(PizzaSizeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PizzaSizeDto> findPizzaSizeById(Long id) {
        return pizzaSizeStorageBroker.findById(PizzaSize.class, id)
                .map(PizzaSizeMapper::toDto);
    }
}
