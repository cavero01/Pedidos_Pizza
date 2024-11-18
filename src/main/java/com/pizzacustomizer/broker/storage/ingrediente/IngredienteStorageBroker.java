package com.pizzacustomizer.broker.storage.ingrediente;

import com.pizzacustomizer.model.entity.Ingrediente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteStorageBroker implements IIngredienteStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ingrediente create(Ingrediente ingrediente) {
        entityManager.persist(ingrediente);
        return ingrediente;
    }

    @Override
    public Ingrediente update(Ingrediente ingrediente) {
        return entityManager.merge(ingrediente);
    }

    @Override
    public List<Ingrediente> findAll(Class<Ingrediente> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<Ingrediente> findById(Class<Ingrediente> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
