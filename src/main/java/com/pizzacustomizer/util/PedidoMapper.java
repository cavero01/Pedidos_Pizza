package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.Pedido;
import com.pizzacustomizer.model.dto.PedidoDto;
import com.pizzacustomizer.util.PizzaPedidoMapper;

import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDto toDto(Pedido entity) {
        PedidoDto dto = new PedidoDto();
        dto.setId(entity.getId());
        dto.setCliente(ClienteMapper.toDto(entity.getCliente()));
        dto.setPizzas(entity.getPizzas()
            .stream()
            .map(PizzaPedidoMapper::toDto) 
            .collect(Collectors.toList()));
        dto.setMetodoEntrega(entity.getMetodoEntrega());
        dto.setCostoDelivery(entity.getCostoDelivery());
        dto.setTotal(entity.getTotal());
        dto.setFechaCreacion(entity.getFechaCreacion());
        return dto;
    }

    public static Pedido toEntity(PedidoDto dto) {
        Pedido entity = new Pedido();
        entity.setId(dto.getId());
        entity.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        entity.setPizzas(dto.getPizzas()
            .stream()
            .map(PizzaPedidoMapper::toEntity) 
            .collect(Collectors.toList()));
        entity.setMetodoEntrega(dto.getMetodoEntrega());
        entity.setCostoDelivery(dto.getCostoDelivery());
        entity.setTotal(dto.getTotal());
        entity.setFechaCreacion(dto.getFechaCreacion());
        return entity;
    }
}

