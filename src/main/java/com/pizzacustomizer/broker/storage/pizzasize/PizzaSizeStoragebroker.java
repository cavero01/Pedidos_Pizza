package com.pizzacustomizer.broker.storage.pizzasize;

import com.pizzacustomizer.model.entity.PizzaSize;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaSizeStoragebroker implements IPizzaSizeStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PizzaSize create(PizzaSize pizzaSize) {
        entityManager.persist(pizzaSize);
        return pizzaSize;
    }

    @Override
    public PizzaSize update(PizzaSize pizzaSize) {
        return entityManager.merge(pizzaSize);
    }

    @Override
    public List<PizzaSize> findAll(Class<PizzaSize> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<PizzaSize> findById(Class<PizzaSize> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
