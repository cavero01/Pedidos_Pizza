package com.pizzacustomizer.service.receta;

import com.pizzacustomizer.broker.storage.receta.IRecetaStoragebroker;
import com.pizzacustomizer.model.dto.RecetaDto;
import com.pizzacustomizer.model.entity.Receta;
import com.pizzacustomizer.util.RecetaMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecetaService implements IRecetaService {

    private final IRecetaStoragebroker recetaStorageBroker;

    public RecetaService(IRecetaStoragebroker recetaStorageBroker) {
        this.recetaStorageBroker = recetaStorageBroker;
    }

    @Override
    @Transactional
    public RecetaDto createReceta(RecetaDto recetaDto) {
        Receta receta = RecetaMapper.toEntity(recetaDto);
        RecetaDto createdReceta = RecetaMapper.toDto(recetaStorageBroker.create(receta));
        return createdReceta;
    }

    @Override
    @Transactional
    public RecetaDto updateReceta(RecetaDto recetaDto) {
        Receta receta = RecetaMapper.toEntity(recetaDto);
        RecetaDto updatedReceta = RecetaMapper.toDto(recetaStorageBroker.update(receta));
        return updatedReceta;
    }

    @Override
    public List<RecetaDto> findAllRecetas() {
        return recetaStorageBroker.findAll(Receta.class).stream()
                .map(RecetaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RecetaDto> findRecetaById(Long id) {
        return recetaStorageBroker.findById(Receta.class, id)
                .map(RecetaMapper::toDto);
    }
}
