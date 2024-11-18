package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.PizzaPedido;

import java.util.stream.Collectors;

import com.pizzacustomizer.model.dto.PizzaDto;

public class PizzaPedidoMapper {

    public static PizzaDto toDto(PizzaPedido entity) {
        PizzaDto dto = new PizzaDto();
        dto.setId(entity.getPizza().getId());
        dto.setNombre(entity.getPizza().getNombre());
        dto.setSize(entity.getPizza().getSize());
        dto.setCosto(entity.getCosto());
        dto.setIngredientes(entity.getPizza().getIngredientes()
            .stream()
            .map(IngredienteMapper::toDto)
            .collect(Collectors.toList()));
        return dto;
    }

    public static PizzaPedido toEntity(PizzaDto dto) {
        PizzaPedido entity = new PizzaPedido();
        entity.setPizza(PizzaMapper.toEntity(dto));
        entity.setCosto(dto.getCosto());
        entity.setPromocion(false); 
        return entity;
    }
}
