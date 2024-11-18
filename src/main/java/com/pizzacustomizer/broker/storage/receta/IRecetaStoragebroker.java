package com.pizzacustomizer.broker.storage.receta;

import com.pizzacustomizer.model.entity.Receta;

import java.util.List;
import java.util.Optional;

public interface IRecetaStoragebroker {
    Receta create(Receta receta);
    Receta update(Receta receta);
    List<Receta> findAll(Class<Receta> type);
    Optional<Receta> findById(Class<Receta> type, Long id);
}
