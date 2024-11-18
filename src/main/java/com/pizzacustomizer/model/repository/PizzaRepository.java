package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.Pizza;  

@Repository
public interface PizzaRepository extends CrudRepository <Pizza,Long>{
    
}
