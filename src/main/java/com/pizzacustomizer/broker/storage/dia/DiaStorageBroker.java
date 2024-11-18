package com.pizzacustomizer.broker.storage.dia;

import com.pizzacustomizer.broker.storage.StorageBroker;
import com.pizzacustomizer.model.entity.Dia;
import com.pizzacustomizer.model.repository.DiaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaStorageBroker extends StorageBroker<Dia, Long> implements IDiaStorageBroker {

    private final DiaRepository diaRepository;

    public DiaStorageBroker(DiaRepository diaRepository) {
        this.diaRepository = diaRepository;
    }

    @Override
    public Optional<Dia> findByNombre(String nombre) {
        return diaRepository.findByNombre(nombre);
    }
}