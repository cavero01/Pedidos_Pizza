package com.pizzacustomizer.broker.storage.dia;

import com.pizzacustomizer.broker.storage.IStorageBroker;
import com.pizzacustomizer.model.entity.Dia;

import java.util.Optional;

public interface IDiaStorageBroker extends IStorageBroker {
    Dia saveDia (Dia dia);
    Dia updateDia(Dia dia);
    Optional<Dia> findDiaById(Long id);
    Optional<Dia> findByNombre(String nombre); 
}