package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.Receta;

@Repository
public interface RecetaRepository extends CrudRepository <Receta,Long> {
    
}
