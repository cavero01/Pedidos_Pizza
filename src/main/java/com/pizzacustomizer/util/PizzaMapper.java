package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.Pizza;
import com.pizzacustomizer.model.dto.PizzaDto;

import java.util.stream.Collectors;

public class PizzaMapper {

    public static PizzaDto toDto(Pizza entity) {
        PizzaDto dto = new PizzaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSize(entity.getSize());
        dto.setCosto(entity.getCosto());
        dto.setIngredientes(entity.getIngredientes()
            .stream()
            .map(IngredienteMapper::toDto)
            .collect(Collectors.toList()));
        return dto;
    }

    public static Pizza toEntity(PizzaDto dto) {
        Pizza entity = new Pizza();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setSize(dto.getSize());
        entity.setCosto(dto.getCosto());
        entity.setIngredientes(dto.getIngredientes()
            .stream()
            .map(IngredienteMapper::toEntity)
            .collect(Collectors.toList()));
        return entity;
    }
}
