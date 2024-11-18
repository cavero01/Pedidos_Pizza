package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizzacustomizer.model.entity.PizzaPedido;

@Repository
public interface PizzaPedidoRepository extends CrudRepository<PizzaPedido, Long> {
    
}
