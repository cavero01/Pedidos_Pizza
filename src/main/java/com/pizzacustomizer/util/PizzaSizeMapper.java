package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.PizzaSize;
import com.pizzacustomizer.model.dto.PizzaSizeDto;

public class PizzaSizeMapper {

    public static PizzaSizeDto toDto(PizzaSize entity) {
        PizzaSizeDto dto = new PizzaSizeDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecioBase(entity.getPrecioBase());
        return dto;
    }

    public static PizzaSize toEntity(PizzaSizeDto dto) {
        PizzaSize entity = new PizzaSize();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecioBase(dto.getPrecioBase());
        return entity;
    }
}
