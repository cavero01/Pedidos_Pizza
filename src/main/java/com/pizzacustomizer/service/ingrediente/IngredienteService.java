package com.pizzacustomizer.service.ingrediente;

import com.pizzacustomizer.broker.storage.ingrediente.IIngredienteStoragebroker;
import com.pizzacustomizer.model.dto.IngredienteDto;
import com.pizzacustomizer.model.entity.Ingrediente;
import com.pizzacustomizer.util.IngredienteMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredienteService implements IIngredienteService {

    private final IIngredienteStoragebroker ingredienteStorageBroker;

    public IngredienteService(IIngredienteStoragebroker ingredienteStorageBroker) {
        this.ingredienteStorageBroker = ingredienteStorageBroker;
    }

    @Override
    @Transactional
    public IngredienteDto createIngrediente(IngredienteDto ingredienteDto) {
        Ingrediente ingrediente = IngredienteMapper.toEntity(ingredienteDto);
        IngredienteDto createdIngrediente = IngredienteMapper.toDto(ingredienteStorageBroker.create(ingrediente));
        return createdIngrediente;
    }

    @Override
    @Transactional
    public IngredienteDto updateIngrediente(IngredienteDto ingredienteDto) {
        Ingrediente ingrediente = IngredienteMapper.toEntity(ingredienteDto);
        IngredienteDto updatedIngrediente = IngredienteMapper.toDto(ingredienteStorageBroker.update(ingrediente));
        return updatedIngrediente;
    }

    @Override
    public List<IngredienteDto> findAllIngredientes() {
        return ingredienteStorageBroker.findAll(Ingrediente.class).stream()
                .map(IngredienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<IngredienteDto> findIngredienteById(Long id) {
        return ingredienteStorageBroker.findById(Ingrediente.class, id)
                .map(IngredienteMapper::toDto);
    }
}
