package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.Receta;
import com.pizzacustomizer.model.dto.RecetaDto;

import java.util.stream.Collectors;

public class RecetaMapper {

    public static RecetaDto toDto(Receta entity) {
        RecetaDto dto = new RecetaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setIngredientes(entity.getIngredientes()
            .stream()
            .map(IngredienteMapper::toDto)
            .collect(Collectors.toList()));
        return dto;
    }

    public static Receta toEntity(RecetaDto dto) {
        Receta entity = new Receta();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setIngredientes(dto.getIngredientes()
            .stream()
            .map(IngredienteMapper::toEntity)
            .collect(Collectors.toList()));
        return entity;
    }
}
