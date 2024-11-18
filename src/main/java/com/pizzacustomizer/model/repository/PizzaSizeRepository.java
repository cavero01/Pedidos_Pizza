package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.PizzaSize;

@Repository
public interface PizzaSizeRepository extends  CrudRepository<PizzaSize, Long>  {
    
}
