package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.Pedido;


@Repository
public interface PedidoRepository extends CrudRepository <Pedido,Long> {
    
}
