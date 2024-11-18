package com.pizzacustomizer.model.repository;

import com.pizzacustomizer.model.entity.Dia;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends CrudRepository<Dia, Long> {
    Optional<Dia> findByNombre(String nombre);
}
