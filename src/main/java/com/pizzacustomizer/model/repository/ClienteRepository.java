package com.pizzacustomizer.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>  {
}
