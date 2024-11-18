package com.pizzacustomizer.broker.storage.pedido;

import com.pizzacustomizer.model.entity.Pedido;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoStoragebroker implements IPedidoStoragebroker {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pedido create(Pedido pedido) {
        entityManager.persist(pedido);
        return pedido;
    }

    @Override
    public Pedido update(Pedido pedido) {
        return entityManager.merge(pedido);
    }

    @Override
    public List<Pedido> findAll(Class<Pedido> type) {
        return entityManager.createQuery("SELECT e FROM " + type.getName() + " e", type).getResultList();
    }

    @Override
    public Optional<Pedido> findById(Class<Pedido> type, Long id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }
}
