package com.pizzacustomizer.broker.storage.pedido;

import com.pizzacustomizer.model.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoStoragebroker {
    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    List<Pedido> findAll(Class<Pedido> type);
    Optional<Pedido> findById(Class<Pedido> type, Long id);
}
