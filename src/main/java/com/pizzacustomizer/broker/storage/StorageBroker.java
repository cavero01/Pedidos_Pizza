package com.pizzacustomizer.broker.storage;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StorageBroker implements IStorageBroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public <T> T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public <T> List<T> findAll(Class<T> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    @Transactional
    public <T> Optional<T> findById(Class<T> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }

    // @Override
    // @Transactional
    // public <T> void delete(T entity) {
    //     entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    // }
}

