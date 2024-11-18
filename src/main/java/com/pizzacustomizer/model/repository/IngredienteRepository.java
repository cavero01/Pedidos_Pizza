package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.Ingrediente;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente,Long>{
    
}
