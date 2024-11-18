package com.pizzacustomizer.broker.storage.ingrediente;

import com.pizzacustomizer.model.entity.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IIngredienteStoragebroker {
    Ingrediente create(Ingrediente ingrediente);
    Ingrediente update(Ingrediente ingrediente);
    List<Ingrediente> findAll(Class<Ingrediente> type);
    Optional<Ingrediente> findById(Class<Ingrediente> type, Long id);
}
