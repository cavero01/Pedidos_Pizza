package com.pizzacustomizer.broker.storage.promociondescuento;

import com.pizzacustomizer.model.entity.PromocionDescuento;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PromocionDescuentoStoragebroker implements IPromocionDescuentoStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PromocionDescuento create(PromocionDescuento promocionDescuento) {
        entityManager.persist(promocionDescuento);
        return promocionDescuento;
    }

    @Override
    public PromocionDescuento update(PromocionDescuento promocionDescuento) {
        return entityManager.merge(promocionDescuento);
    }

    @Override
    public List<PromocionDescuento> findAll(Class<PromocionDescuento> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<PromocionDescuento> findById(Class<PromocionDescuento> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
