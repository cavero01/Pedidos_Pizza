package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.Cliente;
import com.pizzacustomizer.model.dto.ClienteDto;

public class ClienteMapper {

    public static ClienteDto toDto(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        return dto;
    }

    public static Cliente toEntity(ClienteDto dto) {
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        return entity;
    }
}
