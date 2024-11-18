package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.Ingrediente;
import com.pizzacustomizer.model.dto.IngredienteDto;

public class IngredienteMapper {

    public static IngredienteDto toDto(Ingrediente entity) {
        IngredienteDto dto = new IngredienteDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCosto(entity.getCosto());
        return dto;
    }

    public static Ingrediente toEntity(IngredienteDto dto) {
        Ingrediente entity = new Ingrediente();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCosto(dto.getCosto());
        return entity;
    }
}
