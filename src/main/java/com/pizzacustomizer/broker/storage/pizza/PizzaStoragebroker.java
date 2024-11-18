package com.pizzacustomizer.broker.storage.pizza;

import com.pizzacustomizer.model.entity.Pizza;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaStoragebroker extends IStorageBroker implements IPizzaStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pizza create(Pizza pizza) {
        entityManager.persist(pizza);
        return pizza;
    }

    @Override
    public Pizza update(Pizza pizza) {
        return entityManager.merge(pizza);
    }

    @Override
    public List<Pizza> findAll(Class<Pizza> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<Pizza> findById(Class<Pizza> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
