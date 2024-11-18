package com.pizzacustomizer.broker.storage.receta;

import com.pizzacustomizer.model.entity.Receta;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class RecetaStoragebroker implements IRecetaStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Receta create(Receta receta) {
        entityManager.persist(receta);
        return receta;
    }

    @Override
    public Receta update(Receta receta) {
        return entityManager.merge(receta);
    }

    @Override
    public List<Receta> findAll(Class<Receta> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<Receta> findById(Class<Receta> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
